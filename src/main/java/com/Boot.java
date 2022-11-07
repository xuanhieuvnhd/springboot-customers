package com;

import com.service.CustomerService;
import com.service.ProvinceService;
import com.service.impl.CustomerServiceImplWithSpringData;
import com.service.impl.ProvinceServiceImplWithSpringData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Boot {

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImplWithSpringData();
    }

    @Bean
    public ProvinceService provinceService() {
        return new ProvinceServiceImplWithSpringData();
    }
}
