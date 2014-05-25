package com.touresbalon.oms.orders.model.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import com.touresbalon.oms.orders.model.service.dto.OrderDto;

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
	parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public interface OrderService {
		
	@WebMethod
	public void updateStateOrder(@WebParam(name="order") OrderDto orderDto);
		
	@WebMethod(operationName="createOrder")
	public OrderDto createOrder(@WebParam(name="order") OrderDto orderDto);
}
