package com.touresbalon.oms.config;

import javax.servlet.Filter;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OmsWebApplicationInitializer
extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RepositoryOrdersConfig.class, RepositoryProductsConfig.class,  SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/api/v1/*" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter() };
	}

/*
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        //webApplicationContext.register(ApplicationConfig.class, WebMvcConfig.class);

        //Dynamic dynamc = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webApplicationContext));
        //dynamc.addMapping("/api/v1/*");
        //dynamc.setLoadOnStartup(1);
    }
*/


}
