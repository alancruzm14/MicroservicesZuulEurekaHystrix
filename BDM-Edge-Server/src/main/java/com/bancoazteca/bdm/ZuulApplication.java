package com.bancoazteca.bdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@SpringBootApplication
//@Controller
//@EnableZuulProxy
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication extends SpringBootServletInitializer{
	
//    public static void main(String[] args) {
//        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
//        //SpringApplication.run(ZuulApplication.class, args);
//    }
//	public static void main(String[] args) {
//		SpringApplication.run(ZuulApplication.class, args);
//	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(ZuulApplication.class);
	    }

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(ZuulApplication.class, args);
	    }
}
