package com.clubprogramacionbarbaro.covidapi.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String HEADER = "header";
	private static final String STRING = "String";

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.clubprogramacionbarbaro.covidapi"))
				.paths(PathSelectors.any()).build()
				.apiInfo(apiInfo()).forCodeGeneration(true)
				.produces(defaultProducesAndConsumes())
				.consumes(defaultProducesAndConsumes())
				.securitySchemes(securitySchemes())
				.securityContexts(securityContext());
	}

	private List<SecurityContext> securityContext() {
		return Arrays.asList(SecurityContext.builder()
				.securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex("/v1.*"))
				.build());
	}
	
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("Bearer", authorizationScopes));
	}
	
	private List<ApiKey> securitySchemes() {
		return Arrays.asList(new ApiKey("Bearer", "Authorization", "header"));
	}
	
	private ApiInfo apiInfo() {

		return new ApiInfo("CovidApi Documentation",
				"This api helps the hospitals to always have the necessary material during the Covid-19 pandemy", "1.0",
				"urn:tos", defaultContact(), "Apache 2.0", "http://www.apache.org/licences/LICENSE-2.0",
				new HashSet<>());
	}

	private Contact defaultContact() {

		return new Contact("José María Alba", "", "jose.alba17@gmail.com");
	}

	/*private List<Parameter> getGobalParameters() {
		List<Parameter> params = new ArrayList<Parameter>();

		params.add(new ParameterBuilder().name("Authorization Bearer").description("Authorization")
				.modelRef(new ModelRef(STRING)).parameterType(HEADER).required(false).build());

		return params;
	}*/

	private Set<String> defaultProducesAndConsumes() {

		return new HashSet<String>(Arrays.asList("application/json"/* , "application/xml" */));
	}
}
