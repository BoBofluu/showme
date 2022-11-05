package showme.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import showme.controllers.advice.ErrorResponse;

import java.util.Map;

@OpenAPIDefinition(
        info = @Info(
                title = "什麼豬豬忘了",
                description = "功能再想想",
                contact = @Contact(name = "浩兒")
        ),
        servers = {@Server(description = "local", url = "http://localhost:8080/testSpringboot")}
)
@Configuration
public class SwaggerConfig {

    // 預計會設置token
    final String securitySchemeName = "bearerAuth";

    @Bean
    public OpenApiCustomiser globalResponse() {
        return openApi -> {
            openApi.getComponents().addSchemas("Map", new Schema<Map<String, String>>());

            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();
                // 此處可以設置異常處理回傳
                apiResponses.addApiResponse("400", getApiResponse("通用異常處理", ErrorResponse.class));
                apiResponses.addApiResponse("403", getApiResponse("通用權限異常處理", ErrorResponse.class));
            }));
        };

        // 可以設定Security
    }

    // 為異常處理設置方法
    private ApiResponse getApiResponse(String description, Class<?> clazz) {

        return new ApiResponse().description(description)
                .content(new Content()
                        .addMediaType(MediaType.APPLICATION_JSON_VALUE, new io.swagger.v3.oas.models.media.MediaType()
                                .schema(getSchema(clazz))));
    }

    private Schema<?> getSchema(Class<?> clazz) {
        Schema<?> schema = new Schema<>();
        schema.set$ref(String.format("#/components/schemas/%s", clazz.getSimpleName()));
        return schema;
    }
}
