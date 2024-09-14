package com.example.cinemareservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.cinemareservation.model")
@EnableJpaRepositories(basePackages = "com.example.cinemareservation.repository")
public class CinemaReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaReservationApplication.class, args);
    }

}
