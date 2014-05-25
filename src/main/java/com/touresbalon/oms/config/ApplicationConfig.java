package com.touresbalon.oms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;



/**
 * https://www.openshift.com/blogs/day-22-developing-single-page-applications-with-spring-mongodb-and-angularjs
 * 
 * 
 * http://www.concretepage.com/spring/example_propertysource_spring 
 * http://www.javacodegeeks.com/2013/11/how-to-using-propertysource-annotation-in-spring-4-with-java-7.html
 *
 */
@Configuration
@PropertySource("classpath:/mongodb.properties")
public class ApplicationConfig {

	static Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

	@Autowired
	Environment env;

	

}
