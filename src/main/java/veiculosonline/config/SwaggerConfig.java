package veiculosonline.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Rodrigo
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    
    @Value("${swagger.enabled}")
    private boolean swaggerEnabled;
        
    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("veiculosonline.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(getAppInfo())
                .enable(swaggerEnabled);
    }
   
    private ApiInfo getAppInfo(){
        
        return new ApiInfoBuilder().title("VEICULOS ONLINE API")
                .description("Sistema de anúncio e venda de carros")
                .version("1.0")
                .build();
    }
}
