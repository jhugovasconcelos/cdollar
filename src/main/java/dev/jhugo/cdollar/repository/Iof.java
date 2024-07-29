package dev.jhugo.cdollar.repository;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Iof {
    private double iof;

    @Bean
    public double getIof(){
        int year = LocalDate.now().getYear();
        if (year == 2024){iof = 0.0438;}
        else if(year == 2025){iof = 0.0338;}
        else if(year == 2025){iof = 0.0338;}
        else if(year == 2026){iof = 0.0238;}
        else if(year == 2027){iof = 0.0138;}
        else if(year >= 2028){iof = 0.0;}
        return iof;
    }
}
