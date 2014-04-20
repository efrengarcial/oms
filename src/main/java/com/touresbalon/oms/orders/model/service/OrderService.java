package com.touresbalon.oms.orders.model.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import com.touresbalon.oms.orders.model.entity.Order;

/**
 * http://www.ibm.com/developerworks/library/ws-whichwsdl/
 * http://www.coderanch.com/t/627212/java-Web-Services-SCDJWS/certification/SOAP-SOAP#2869971
 * 
 * @author 13719643
 *
 */
@WebService
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING) 
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL,
	parameterStyle=SOAPBinding.ParameterStyle.BARE)
public interface OrderService {
		
	@WebMethod
	public void updateStateOrder(@WebParam(name="idOrder") String idOrder,@WebParam(name="state") String state);
		
	@WebMethod(operationName="createOrder")
	public String createOrder(@WebParam(name="order") Order order);
}
