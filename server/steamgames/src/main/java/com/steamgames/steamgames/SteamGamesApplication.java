package com.steamgames.steamgames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SteamGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteamGamesApplication.class, args);
	}

}
