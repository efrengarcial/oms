package com.touresbalon.oms.config.ldap;

import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.directory.api.ldap.model.cursor.CursorException;
import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.api.ldap.model.name.Dn;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LdapManager {
	
	static Logger log = LoggerFactory.getLogger(LdapManager.class);
	
    public static ResourceBundle props = ResourceBundle.getBundle("ldap");
    private static String host = props.getString("host");
    private static String port = props.getString("port");
    private static String admin = props.getString("admin");
    private static String pwd = props.getString("pwd");
    private static String dn = props.getString("baseDn");
    private static String managerDn = props.getString("managerDn");
    private static String peopleDn = props.getString("peopleDn");
    
    
    private LdapConnection getConnection(String host, String port) {
        LdapConnection conn =  null;
        int portNumber = 0;

        try {
            portNumber = Integer.parseInt(port);
            conn = new LdapNetworkConnection(host, portNumber);
            conn.setTimeOut(0);
            conn.bind(LdapManager.managerDn, LdapManager.pwd);
        } catch (NumberFormatException | LdapException | IOException nfe) {
            log.error(nfe.getMessage());
        }                    
        return conn;                    
    }
    
    
    public boolean login(LdapConnection conn, String uid, String pwd) throws LdapException {
    	Dn dn = getDn(conn, uid);
    	return login(conn, dn, pwd);
    }
    
    
    public boolean login(LdapConnection conn, Dn dn, String pwd) throws LdapException {                
        return conn.compare(dn, "userPassword", pwd);
    }
    
    private Dn getDn(LdapConnection conn, String uid) {
    	Dn dn = new Dn();
    	
    	try {
    		String sUid = "(uid="+uid+")";
    		EntryCursor cursor = conn.search(peopleDn, sUid, SearchScope.ONELEVEL);    		
	    	if (cursor.next()) {
	    		Entry entry = cursor.get();
	    		dn = entry.getDn();
	    	}
    	} catch (LdapException | CursorException | IOException le) {
    		System.out.println(le.getMessage());
    		log.error(le.getMessage());
    	}
    	return dn;
    }
    

    
    public boolean memberOf(LdapConnection conn, String uid, Privilege privilege) throws LdapException {
        Dn dn = getDn(conn, uid);
        return memberOf(conn, dn, privilege);
    }
    
    public boolean memberOf(LdapConnection conn, Dn dn, Privilege privilege) throws LdapException {
        Entry entry = conn.lookup(privilege.getDn());
        return conn.compare(entry.getDn(), "member", dn.getName());
    }

	public static void main(String[] args) {
		LdapManager ldapMgr = new LdapManager();
		try {
			LdapConnection conn = ldapMgr.getConnection(host, port);
			boolean rta = ldapMgr.login(conn, "aVillalba", "aVillalba");
			System.out.println("Login: " + rta);
			rta = ldapMgr.memberOf(conn, "aVillalba", Privilege.CAMPANNAS);
			System.out.println("Member: " + rta);
		} catch (LdapException le) {
			System.out.println(le.getMessage());
		}

	}

}
