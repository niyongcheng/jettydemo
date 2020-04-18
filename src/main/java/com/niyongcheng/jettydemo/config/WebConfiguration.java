package com.niyongcheng.jettydemo.config;


import com.niyongcheng.jettydemo.service.AutoIdempotentInterceptor;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
//@Slf4j
public class WebConfiguration extends WebMvcConfigurationSupport {

    //private final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

    @Resource
    private AutoIdempotentInterceptor autoIdempotentInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        /*logger.trace("this is one track message");
        logger.debug("{} is running {}","WebConfiguration"," in action");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
*/
        registry.addInterceptor(autoIdempotentInterceptor);
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
