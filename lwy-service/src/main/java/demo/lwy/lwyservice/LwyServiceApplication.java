package demo.lwy.lwyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableScheduling
public class LwyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LwyServiceApplication.class, args);
	}

}
