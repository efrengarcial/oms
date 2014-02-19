package com.touresbalon.oms.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;
import com.touresbalon.oms.domain.Data;
import com.touresbalon.oms.domain.Parametro;
import com.touresbalon.oms.repository.ParametroRepository;

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
/*@ComponentScan(basePackages = "com.touresbalon.oms.config",
        excludeFilters = {@ComponentScan.Filter(Configuration.class)})*/
@PropertySource("classpath:/oracledb.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses =ParametroRepository.class)
@EnableLoadTimeWeaving 
public class RepositoryOracleConfig {
    private static final Logger logger = LoggerFactory
            .getLogger(RepositoryOracleConfig.class);

    @Value("#{ environment['database.driverClassName']?:'' }")
    private String dbDriverClass;
    @Value("#{ environment['database.url']?:'' }")
    private String dbUrl;
    @Value("#{ environment['database.username']?:'' }")
    private String dbUserName;
    @Value("#{ environment['database.password']?:'' }")
    private String dbPassword;
    @Value("#{ environment['database.vendor']?:'' }")
    private String dbVendor;

    @Autowired
    BeanFactory beanFactory;

    @SuppressWarnings("unused")
	@Autowired
    private Environment environment;

    @Autowired LoadTimeWeaver loadTimeWeaver;
   
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Parametro parametro() {
        logger.debug("*** Creating Data");
        return new Parametro();
    }
   

    @Bean
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
        return bean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
            throws Exception {
        logger.trace("Vendor '{}'", dbVendor);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
         // loadTimeWeaver will be available if 
        //   @EnableLoadTimeWeaving is specified in this 
        //   config class (annotated with @Configuration) 
        //https://jira.springsource.org/browse/SPR-10856
        //http://stackoverflow.com/questions/10769051/eclipselinkjpavendoradapter-instead-of-hibernatejpavendoradapter-issue        
        factory.setLoadTimeWeaver(this.loadTimeWeaver);        
        factory.setDataSource(dataSource());
        logger.debug("Scanning Package '{}' for entities",
                Data.class.getPackage().getName());
        factory.setPackagesToScan(Parametro.class.getPackage().getName());

        EclipseLinkJpaVendorAdapter jpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.valueOf(dbVendor));
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);        

        factory.setJpaVendorAdapter(jpaVendorAdapter);

        // No persistence.xml - thanks to packagesToScan
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        JpaTransactionManager bean = new JpaTransactionManager();
        bean.setEntityManagerFactory(entityManagerFactory().getObject());
        bean.setDataSource(dataSource());
        bean.afterPropertiesSet();

        return bean;
    }

    @Bean
    public EntityManager entityManager() throws Exception {
        if (entityManagerFactory() == null)
            logger.error("CEMF IS NULL");

        EntityManager bean = null;

        EntityManagerFactory entityManagerFactory = entityManagerFactory()
                .getObject();
        if (entityManagerFactory == null) {
            logger.error("EMF IS NULL");
            return null;
        } else {
            bean = entityManagerFactory.createEntityManager();
            if (bean == null) {
                logger.error("EM IS NULL");
                return null;
            }
        }

        return bean;
    }
}
