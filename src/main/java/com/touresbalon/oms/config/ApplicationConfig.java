package com.touresbalon.oms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.touresbalon.framework.controller.GlobalControllerExceptionHandler;
import com.touresbalon.oms.api.PingResource;
import com.touresbalon.oms.repository.mongo.StoryRepository;



/**
 * https://www.openshift.com/blogs/day-22-developing-single-page-applications-with-spring-mongodb-and-angularjs
 * 
 * 
 * http://www.concretepage.com/spring/example_propertysource_spring 
 * http://www.javacodegeeks.com/2013/11/how-to-using-propertysource-annotation-in-spring-4-with-java-7.html
 *
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = StoryRepository.class)
@PropertySource("classpath:/mongodb.properties")
public class ApplicationConfig {

	static Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

	@Autowired
	Environment env;

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		logger.info("Test logger......");
		String openshiftMongoDbHost =env.getRequiredProperty("mongo.db.host");  //System.getenv("OPENSHIFT_MONGODB_DB_HOST");
		int openshiftMongoDbPort =Integer.parseInt(env.getRequiredProperty("mongo.db.port")); //Integer.parseInt(System.getenv("OPENSHIFT_MONGODB_DB_PORT"));
		String username = env.getRequiredProperty("mongo.db.username");//System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
		String password =env.getRequiredProperty("mongo.db.password");//System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
		Mongo mongo = new Mongo(openshiftMongoDbHost, openshiftMongoDbPort);
		UserCredentials userCredentials = new UserCredentials(username, password);
		String databaseName = env.getRequiredProperty("mongo.db.name");//System.getenv("OPENSHIFT_APP_NAME");
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName, userCredentials);
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
		return mongoTemplate;
	}

}
