package com.touresbalon.oms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 * http://docs.spring.io/spring-security/site/docs/3.2.x/guides/hellomvc.html
 * http://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security/#aacdsi
 * 
 * 
 * http://meera-subbarao.blogspot.co.uk/2010/11/spring-security-combining-basic-and.html
 * 
 * https://github.com/spring-projects/spring-security/blob/master/config/src/test/groovy/org/springframework/security/config/annotation/web/SampleWebSecurityConfigurerAdapterTests.groovy#L277
 * http://stackoverflow.com/questions/18815015/creating-multiple-http-sections-in-spring-security-java-config
 * http://stackoverflow.com/questions/19353578/security-method-annotations-with-java-configuration-and-spring-security-3-2
 * http://www.javacodegeeks.com/2013/05/spring-security-login.html
 * http://stackoverflow.com/questions/21046062/spring-security-3-2-code-based-configuration-form-login-global-method-securit 
 * http://www.javacodegeeks.com/2013/05/spring-security-login.html
 * 
 * 
 * http://spring.io/blog/2013/08/21/spring-security-3-2-0-rc1-highlights-csrf-protection
 * http://jpgmr.wordpress.com/2014/01/03/spring-security-csrf-protection-in-a-backbone-single-page-app/
 * 
 * 
 * token:
 * http://spring.io/blog/2013/08/21/spring-security-3-2-0-rc1-highlights-csrf-protection/
 * http://stackoverflow.com/questions/14109927/angular-js-verify-csrf-token-in-post-request
 * http://jpgmr.wordpress.com/2014/01/03/spring-security-csrf-protection-in-a-backbone-single-page-app/
 * http://thomas.rabaix.net/blog/2013/05/csrf-token-security-with-angularjs
 * 
 * http://security.stackexchange.com/questions/43503/how-to-share-csrf-token-to-client-application
 * http://angularjs-best-practices.blogspot.com/2013/07/angularjs-and-xsrfcsrf-cross-site.html
 * 
 * @author 13719643
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.ldapAuthentication()
			.userDnPatterns("uid={0},ou=People,dc=touresBalon,dc=com")
			.userSearchFilter("uid={0}")    		
			.groupSearchBase("ou=People")
				.contextSource()
					.url("ldap://192.168.1.109:389/dc=touresBalon,dc=com")
					.managerDn("cn=Manager,dc=touresBalon,dc=com")
					.managerPassword("master");

    }
    
    

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
            	.addFilterAfter(new CsrfTokenGeneratorFilter(), CsrfFilter.class)
                .antMatcher("/api/v1/**")
                .authorizeRequests()
                    .antMatchers("/api/v1/admin/**").hasRole("ADMIN")
                    .antMatchers("/api/v1/**").hasRole("USER")
                    .and()
                .httpBasic();
        }
    }
    
    @Configuration   
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(WebSecurity web) throws Exception {
        	  web
              .ignoring()
                 .antMatchers("/css/**","/js/**","/img/**"); // #3
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	  http
        	  //.addFilterAfter(new CsrfTokenGeneratorFilter(), CsrfFilter.class)
        	  .csrf().disable()
              .authorizeRequests()
                .antMatchers("/signup","/about","/services/**").permitAll() // #4
                .antMatchers("/admin/**").hasRole("ADMIN") // #6
                 .anyRequest().authenticated() // #7
                //.anyRequest().hasRole("USER")
                .and()
               .formLogin()
	             	.loginPage("/login.jsp")             	
	             	.failureUrl("/login.jsp?error=true")
	             	.loginProcessingUrl("/j_spring_security_check")
	             	.usernameParameter("j_username")
	             	.passwordParameter("j_password")
	             	.permitAll()
             	 .and()
                 .logout()
                     .logoutUrl("/j_spring_security_logout")
                     .logoutSuccessUrl("/index.html");
        	
        	/*http.csrf().disable().authorizeRequests().anyRequest().hasRole("USER").and()
             .formLogin()
             	.loginPage("/login.jsp")             	
             	.failureUrl("/login.jsp?error=true")
             	.permitAll();*/
        }
    }    
   
}