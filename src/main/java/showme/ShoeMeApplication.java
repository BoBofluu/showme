package showme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"showme.*"})
public class ShoeMeApplication {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(ShoeMeApplication.class, args);
    }

}
