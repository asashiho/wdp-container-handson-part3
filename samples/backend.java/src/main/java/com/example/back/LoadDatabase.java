package com.example.back;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repo) {

        return args -> {
            //log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repo.save(new Product("りんご", "甘酸っぱくておいしい", 150)));
            log.info("Preloading " + repo.save(new Product("バナナ", "完熟でスムージーにおすすめ",200)));
            log.info("Preloading " + repo.save(new Product("マスカット", "皮も食べられます",1000)));

        };
    }
}