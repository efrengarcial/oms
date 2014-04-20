package com.touresbalon.oms.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.touresbalon.oms.orders.model.service.impl.OrderServiceImpl;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml",
				  "classpath:META-INF/cxf/cxf-extension-soap.xml",	
				  "classpath:META-INF/cxf/cxf-servlet.xml"})
public class CXFConfig {
	
	@Autowired
	Bus cxfBus;

	// More code

	@Bean
	public Endpoint order() {
		EndpointImpl endpoint = new EndpointImpl(cxfBus, new OrderServiceImpl());
		endpoint.setAddress("/OrderService");
		endpoint.publish();
		return endpoint;
	}
}