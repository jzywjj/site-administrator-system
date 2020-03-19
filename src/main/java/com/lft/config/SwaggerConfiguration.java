
package com.lft.config;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Autowired
	private Environment environment;

	@Bean(value = "defaultApi")
	public Docket defaultApi() {
		Profiles isEnabled = Profiles.of("dev", "test","default");
		boolean isAccept = environment.acceptsProfiles(isEnabled);
		ParameterBuilder parameterBuilder = new ParameterBuilder();
		List<Parameter> parameters = Lists.newArrayList();
//		parameterBuilder.name("token").description("token令牌").modelRef(new ModelRef("String")).parameterType("header")
//				.required(true).build();
//		parameters.add(parameterBuilder.build());

		Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("site-administrator-system")
				.ignoredParameterTypes(HttpServlet.class, HttpServletRequest.class, HttpSession.class).enable(isAccept)
				.apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.lft.controller"))
				.paths(PathSelectors.any()).build().globalOperationParameters(parameters);

		return docket;
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("zhiyong.jin", null, "zhiyong.jin@aliyun.com");
		return new ApiInfoBuilder().title("亮风台数据中心").description("高速智慧工地指挥中心API")
				.termsOfServiceUrl("http://tengyun.aryun.com.cn").contact(contact).version("1.0").build();
	}

}
