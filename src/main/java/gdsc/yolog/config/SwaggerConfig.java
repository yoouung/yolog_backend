package gdsc.yolog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration // 설정 파일임을 명시하기 위한 annotation
public class SwaggerConfig {
    // Docket : Swagger 설정의 핵심이 되는 Bean (Bean : 스프링 컨테이너에 등록되어 관리되는 객체)
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("gdsc.yolog.controller")) // swagger 문서를 적용할 api 패키지 설정
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()); // 제목, 설명 등 문서에 대한 정보
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("GDSC API Docs") // API 문서 제목
                .description("API Document for GDSC Web Blog") // API 설명
                .version("1.0") // API version
                .build();
    }

}
