package com.woody.woodycameraapi.config;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("camera")
                .addOpenApiCustomiser(userApiCustomise())
                .build();
    }

    /**
     * 定义 OpenApiCustomiser ，用于指定的 group
     */
    public OpenApiCustomiser userApiCustomise() {
        return openApi -> openApi.info(new io.swagger.v3.oas.models.info.Info()
                .title("Woody的相机 API 文档")
                .description("Woody的相机")
                .version("1.0")
                .contact(new io.swagger.v3.oas.models.info.Contact().name("Woody").email("woody@woody.com")));
    }
}
