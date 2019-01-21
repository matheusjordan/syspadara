package syspadara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"syspadara.*"})
public class App {
	
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	}
	
}
