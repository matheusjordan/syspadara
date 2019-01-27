package syspadara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.annotations.Api;

@Api(value = "API REST SYSPADARA")
@SpringBootApplication()
public class App {
	
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}
	
}
