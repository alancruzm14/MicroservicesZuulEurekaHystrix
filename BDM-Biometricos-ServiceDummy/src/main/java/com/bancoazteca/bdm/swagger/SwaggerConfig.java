package com.bancoazteca.bdm.swagger;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	String oAuthServerUri = "oAuthServerUri";
	String clientId = "clientId";
	String clientSecret = "clientSecret";

	@Bean
	public Docket api() {

		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("X-3scale-proxy-secret-token").modelRef(new ModelRef("string")).parameterType("header")
				.defaultValue("250192010292Like").build();

		List<Parameter> aParameters = new ArrayList<Parameter>();
		// aParameters.add(aParameterBuilder.build());
		aParameters.add(new ParameterBuilder().name("Authorization").description("Bearer Token")
				.modelRef(new ModelRef("string")).parameterType("header").required(false)
				.defaultValue("Bearer Token XXXX").build());

//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.bancoazteca.bdm.controller.*")).paths(PathSelectors.any()).build()
//				.apiInfo(apiInfo()).protocols(protocols())
//				// .securitySchemes(newArrayList(new ApiKey("Token Access",
//				// HttpHeaders.AUTHORIZATION, " Bearer")))
//				.securityContexts(newArrayList(securityContext())).globalOperationParameters(aParameters);
		

		return new Docket(DocumentationType.SWAGGER_2)  
		          .select()                                  
		          .apis(RequestHandlerSelectors.basePackage("com.bancoazteca.bdm"))              
		          .paths(PathSelectors.any())                          
		          .build();
		
		
		//All paths que detecte Swagger
//		return new Docket(DocumentationType.SWAGGER_2)  
//		          .select()                                  
//		          .apis(RequestHandlerSelectors.any())              
//		          .paths(PathSelectors.any())                          
//		          .build();  
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	private Set<String> protocols() {
		Set<String> protocols = new HashSet<>();
		protocols.add("http");
		return protocols;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Bank as a Service Documentation swagger")
				.description("BAZ-API Swagger Documentation").termsOfServiceUrl("http://bancoazteca.com")
				.contact(new Contact("Banco Azteca SA de CV", "bancoazteca.com", "bancoazteca@gmail.com"))
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.version("1.0").build();
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/anyPath.*"))
				.build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(new SecurityReference("mykey", authorizationScopes));
	}
}