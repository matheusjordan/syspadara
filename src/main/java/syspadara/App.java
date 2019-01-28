package syspadara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(value = "API REST SYSPADARA")
@EnableSwagger2
@SpringBootApplication()
public class App {
	
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}
	
}
