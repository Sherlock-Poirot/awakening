package com.detective.stone.awakening.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Detective Stone Create time 2020/12/03
 * <p>
 * swagger2配置类
 */
@Configuration
@EnableSwagger2 //启用swagger2
public class Swagger2Config {

  private static final String BASE_PACKAGE = "com.detective.stone.awakening.company";

  @Bean
  public Docket buildDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(buildApiInfo())
        .enable(true) // 是否开启swagger2 将来采用配置
        .select()
        .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo buildApiInfo() {
    return new ApiInfoBuilder()
        .title("company的api文档")
        .description("DetectiveStone搭建的基础模块swagger2 api文档")
        .termsOfServiceUrl("https://github.com/Sherlock-Poirot/awakening")
        .contact(new Contact("DetectiveStone", "", "348735716@qq.com"))
        .version("1.0")
        .build();
  }
}
