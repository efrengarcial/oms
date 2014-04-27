package com.touresbalon.oms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.touresbalon.framework.controller.GlobalControllerExceptionHandler;
import com.touresbalon.oms.api.PingResource;
import com.touresbalon.oms.orders.controller.OrderController;
import com.touresbalon.oms.orders.controller.ParameterController;
import com.touresbalon.oms.orders.model.mgr.OrderManager;
import com.touresbalon.oms.products.controller.ProductController;
import com.touresbalon.oms.products.model.mgr.ProductoManager;

@EnableWebMvc
@ComponentScan(basePackageClasses = {  GlobalControllerExceptionHandler.class , PingResource.class} )//,
										//ParameterController.class, ProductController.class, OrderController.class} )
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MappingJacksonJsonView jsonView() {
        MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
        jsonView.setPrefixJson(true);
        return jsonView;
    }
}
