package com.touresbalon.oms.config.ldap;

public enum Privilege {
	
    
    PLATINO(0,"cn=Platino,ou=B2C,ou=Group,dc=touresBalon,dc=com"),
    DORADO(1,"cn=Oro,ou=B2C,ou=Group,dc=touresBalon,dc=com"),
    PLATEADO(2,"cn=Plata,ou=B2C,ou=Group,dc=touresBalon,dc=com"),
    PRODUCTOS_CONSULTA(3,"cn=Productos_Consulta,ou=Employees,ou=Group,dc=touresBalon,dc=com"),
    PRODUCTOS_ADMON(4,"cn=Productos_Admon,ou=Employees,ou=Group,dc=touresBalon,dc=com"),
    CAMPANNAS(5,"cn=Campannas,ou=Employees,ou=Group,dc=touresBalon,dc=com"),
    ORDENES_CONSULTA(6,"cn=Ordenes_Consulta,ou=Employees,ou=Group,dc=touresBalon,dc=com"),
    ORDENES_ADMON(7,"cn=Ordenes_Admon,ou=Employees,ou=Group,dc=touresBalon,dc=com"),
    CLIENTES_CONSULTA(8,"cn=Clientes_Consulta,ou=Employees,ou=Group,dc=touresBalon,dc=com"),
    CLIENTES_ADMON(9,"cn=Clientes_Admon,ou=Employees,ou=Group,dc=touresBalon,dc=com");
    
    private final int index;
    private final String dn;
    Privilege(int index, String dn) {
        this.index=index;
        this.dn=dn;
    }
    
    public String getDn() {
        return dn;
    }
    
    public int getIndex() {
        return index;
    }

}
