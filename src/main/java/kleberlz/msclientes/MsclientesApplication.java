package kleberlz.msclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//EnableEurekaClient não precisa mais.
public class MsclientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsclientesApplication.class, args);
	}

}
