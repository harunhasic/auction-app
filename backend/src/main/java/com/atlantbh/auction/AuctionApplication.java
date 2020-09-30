package com.atlantbh.auction;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

;

@SpringBootApplication
@ComponentScan("com.atlantbh.auction.*")
public class AuctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionApplication.class, args);

	}
}
