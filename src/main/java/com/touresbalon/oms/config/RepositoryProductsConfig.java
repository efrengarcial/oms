package com.touresbalon.oms.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;
import com.touresbalon.oms.products.controller.ProductController;
import com.touresbalon.oms.products.model.dao.ProductDao;
import com.touresbalon.oms.products.model.entity.Producto;
import com.touresbalon.oms.products.model.mgr.ProductManager;

/**
 * http://gordondickens.com/wordpress/2013/02/28/database-config-spring-3-2-environment-profiles/
 * http://softdevbuilttolast.wordpress.com/2013/10/30/spring-and-jpa-configuring-spring-programmatically-for-hibernate-eclipselink-openjpa-and-datanucleus/
 * 
 * <p/>
 * <ul>
 * <li>{@link Configuration} - defines this class as a Spring Configuration class</li>
 * <li>{@link ComponentScan} - replaces &lt;context:component-scan/&gt;</li>
 * <li>{@link PropertySource} - replaces &lt;context:property-placeholder/&gt;</li>
 * <li>{@link EnableTransactionManagement} - replaces &lt;tx:annotation-driven/&gt;</li>
 * <li>{@link EnableJpaRepositories} - replaces Spring Data Jpa &lt;jpa:repositories/&gt;</li>
 * <li>{@link Bean} - replaces  &lt;bean/&gt;</li>
 * <li>{@link Scope} - replaces  &lt;bean scope=""/&gt;</li>
 * </ul>
 *
 * @author Efren Garcia
 */
@Configuration
@PropertySource("classpath:/sqlserverdb.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {ProductDao.class},
entityManagerFactoryRef = "entityManagerFactoryProduct", 
transactionManagerRef = "transactionManagerProduct"
)
@ComponentScan(basePackageClasses = { ProductController.class, ProductManager.class } )

public class RepositoryProductsConfig {
    private static final Logger logger = LoggerFactory.getLogger(RepositoryProductsConfig.class);

    @Value("#{ environment['database.sqlServer.driverClassName']?:'' }")
    private String dbDriverClass;
    @Value("#{ environment['database.sqlServer.url']?:'' }")
    private String dbUrl;
    @Value("#{ environment['database.sqlServer.username']?:'' }")
    private String dbUserName;
    @Value("#{ environment['database.sqlServer.password']?:'' }")
    private String dbPassword;
    @Value("#{ environment['database.sqlServer.vendor']?:'' }")
    private String dbVendor;
  
	@Autowired
    private Environment environment;

      
    @Bean(name="producto")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Producto producto() {
        logger.debug("*** Creating Data");
        return new Producto();
    }
   

    @Bean(name="dataSourceProduct")
    public DataSource dataSource() {
        logger.debug("*** 1. Creating dataSource");
        logger.trace("URL '{}'", dbUrl);
        logger.trace("Driver '{}'", dbDriverClass);
        logger.trace("UserName '{}'", dbUserName);
        logger.trace("dbPassword '{}'", dbPassword);
        //http://jolbox.com/
        BoneCPDataSource  bean = new BoneCPDataSource ();
        bean.setPassword(dbPassword);
        bean.setJdbcUrl(dbUrl);
        bean.setUsername(dbUserName);
        bean.setDriverClass(dbDriverClass);  
        bean.setMaxConnectionsPerPartition(50);
        bean.setMinConnectionsPerPartition(2);
                
        /*<property name="driverClass" value="${dataSource.driverClass}" />
        <property name="jdbcUrl" value="${dataSource.jdbcUrl}" />
        <property name="username" value="${dataSource.username}" />
        <property name="password" value="${dataSource.password}" />
        <property name="idleConnectionTestPeriodInMinutes" value="60" />
        <property name="idleMaxAgeInMinutes" value="240" />
        <property name="maxConnectionsPerPartition" value="${dataSource.maxConnections}" />
        <property name="minConnectionsPerPartition" value="${dataSource.minConnections}" />
        <property name="partitionCount" value="3" />
        <property name="acquireIncrement" value="5" />
        <property name="statementsCacheSize" value="100" />
        <property name="releaseHelperThreads" value="3" />
        <property name="connectionTimeoutInMs" value="${dataSource.connectionTimeoutInMs}"></property>*/
        return bean;
    }

    @Bean(name ="entityManagerFactoryProduct")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.touresbalon.oms.products.model.entity" });
        em.setBeanName("entityManagerFactoryProduct");
   
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        em.setPersistenceUnitName("productPersistenceUnit");
   
        return em;
     }

    @Bean(name ="transactionManagerProduct")    
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
   
        return transactionManager;
     }   

  
    @Bean(name="exceptionTranslationProduct")
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
       return new PersistenceExceptionTranslationPostProcessor();
    }

    @SuppressWarnings("serial")
	Properties hibernateProperties() {
       return new Properties() {
          {
             setProperty("hibernate.hbm2ddl.auto", "none");
             setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2008Dialect");
             setProperty("hibernate.globally_quoted_identifiers", "true");
          }
       };
    }
    
}
