package showme.openAi;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties("openai")
@Getter
@Setter
public class OpenAiCommon {

    @Value("apiUserKey")
    private String apiUserKey;
}
