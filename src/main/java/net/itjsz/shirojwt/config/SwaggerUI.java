package net.itjsz.shirojwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmy on 2018/8/28.
 *
 * @author lmy
 * @project itjsz-blog
 * @date 2018/8/28
 */
@Configuration
@EnableSwagger2
public class SwaggerUI {
    @Bean
    public Docket userApi() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameterBuilder.name("token")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        parameters.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2).groupName("系统接口文档").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("net.itjsz.shirojwt.controller.sys"))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(parameters);
    }
    @Bean
    public Docket loginApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("登录接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.itjsz.shirojwt.controller.login"))
                .paths(PathSelectors.any()).build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("权限管理系统").description("api").termsOfServiceUrl("")
                .contact(new Contact("IT技术栈", "www.itjsz.net", "lmy@itjsz.net")).version("1.0").build();
    }
}
