package testspringboot.config.database;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties("app.datasource")
@Data
public class ConnectionProperties {

    @Value("url")
    private String url;

    @Value("username")
    private String userName;

    @Value("pass_word")
    private String password;

    @Value("driver-class-name")
    private String driverClassName;
}
