
package com.aes.service.accounts.model;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "OrderManagementIF", targetNamespace = "http://OrderManagementLib/com/touresbalon/interfaces/OrderManagementIF")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OrderManagementIF {


    /**
     * 
     * @param request
     */
    @WebMethod(action = "http://OrderManagementLib/com/touresbalon/interfaces/OrderManagementIF/OrderManagementIF/startProcess")
    @Oneway
    @RequestWrapper(localName = "startProcess", targetNamespace = "http://OrderManagementLib/com/touresbalon/interfaces/OrderManagementIF", className = "com.aes.service.accounts.model.StartProcess")
    public void startProcess(
        @WebParam(name = "request", targetNamespace = "")
        Order request);

    /**
     * 
     * @param orderID
     */
    @WebMethod(action = "http://OrderManagementLib/com/touresbalon/interfaces/OrderManagementIF/OrderManagementIF/cancelProcess")
    @Oneway
    @RequestWrapper(localName = "cancelProcess", targetNamespace = "http://OrderManagementLib/com/touresbalon/interfaces/OrderManagementIF", className = "com.aes.service.accounts.model.CancelProcess")
    public void cancelProcess(
        @WebParam(name = "orderID", targetNamespace = "")
        String orderID);

}
