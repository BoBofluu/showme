package testspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "testspringboot.*" })
public class TestSpringbootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TestSpringbootApplication.class, args);
	}

}
