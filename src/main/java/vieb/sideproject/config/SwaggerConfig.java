package vieb.sideproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    // http://localhost:8080/project-deployment/swagger-ui/index.html
    @Bean
    public OpenAPI swaggerConfigCustom() {
        return new OpenAPI()
                .info(new Info()
                        .title("Test deployment")
                        .description("My side deployment project")
                        .version("1.0.0-SNAPSHOT")
                );
    }
}
