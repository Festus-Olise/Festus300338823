package com.example.finalexamsetb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.finalexamsetb.Entities.Salesman;
import com.example.finalexamsetb.Repositories.SalesmanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

import static com.example.finalexamsetb.Repositories.SalesmanRepository.*;

@SpringBootApplication
public class FinalExamSetBApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalExamSetBApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(SalesmanRepository salesmanRepository){
        return args -> {
            salesmanRepository.save(new Salesman(null, 2000.0, new Date(), "Washing Machine", "Festus Olise"));
            salesmanRepository.save(new Salesman(null, 3500.0, new Date(), "refrigerator", "Charles Olise"));
            salesmanRepository.save(new Salesman(null, 1600.0, new Date(), "Washing Machine", "Festus Olise"));
            salesmanRepository.save(new Salesman(null, 8900.5, new Date(), "Music System", "Charles Olise"));
            salesmanRepository.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };
    }

}
