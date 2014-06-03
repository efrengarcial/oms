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
import com.touresbalon.oms.orders.controller.OrderController;
import com.touresbalon.oms.orders.model.dao.OrderCustomDao;
import com.touresbalon.oms.orders.model.dao.OrderDao;
import com.touresbalon.oms.orders.model.entity.Order;
import com.touresbalon.oms.orders.model.mgr.OrderManager;
import com.touresbalon.oms.orders.model.service.impl.OrderServiceImpl;

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
@PropertySource("classpath:/oracledb.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {OrderDao.class},repositoryImplementationPostfix="CustomImpl",
entityManagerFactoryRef = "entityManagerFactoryOrders", 
transactionManagerRef = "transactionManagerOrders"
)
@ComponentScan(basePackageClasses = { OrderController.class, OrderManager.class ,OrderServiceImpl.class } )

public class RepositoryOrdersConfig {
    private static final Logger logger = LoggerFactory.getLogger(RepositoryOrdersConfig.class);

    @Value("#{ environment['database.oracle.driverClassName']?:'' }")
    private String dbDriverClass;
    @Value("#{ environment['database.oracle.url']?:'' }")
    private String dbUrl;
    @Value("#{ environment['database.oracle.username']?:'' }")
    private String dbUserName;
    @Value("#{ environment['database.oracle.password']?:'' }")
    private String dbPassword;
    @Value("#{ environment['database.oracle.vendor']?:'' }")
    private String dbVendor;

	@Autowired
    private Environment environment;

    @Bean(name="order")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Order order() {
        logger.debug("*** Creating Data");
        return new Order();
    }
   

    @Bean(name="dataSourceOracle")
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
        bean.setMinConnectionsPerPartition(20);
        
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
    
    @Bean(name ="entityManagerFactoryOrders")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
       LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
       em.setDataSource(dataSource());
       em.setPackagesToScan(new String[] { "com.touresbalon.oms.orders.model.entity" });
       em.setBeanName("entityManagerFactoryOrders");
  
       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       em.setJpaVendorAdapter(vendorAdapter);
       em.setJpaProperties(hibernateProperties());
       em.setPersistenceUnitName("ordersPersistenceUnit");
  
       return em;
    }
    
    @Bean(name ="transactionManagerOrders")
    public PlatformTransactionManager transactionManager(){
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
  
       return transactionManager;
    }   
  
   
    @Bean(name="exceptionTranslationOracle")
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
       return new PersistenceExceptionTranslationPostProcessor();
    }

    @SuppressWarnings("serial")
	Properties hibernateProperties() {
       return new Properties() {
          {
             setProperty("hibernate.hbm2ddl.auto", "none");
             setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
             setProperty("hibernate.globally_quoted_identifiers", "true");
          }
       };
    }
  
}
