package com.grayMatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentWalletApplication.class, args);
		System.out.println("app running");
	}

}
