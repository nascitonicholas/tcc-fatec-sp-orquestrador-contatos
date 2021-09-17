package br.com.fatec.sp.tcc.orquestradorcontatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrquestradorContatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestradorContatosApplication.class, args);
	}

}
