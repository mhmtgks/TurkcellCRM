package com.turkcell.TurkcellCRM.customerService;


import com.turkcell.TurkcellCRM.CoreService.configuration.BaseSecurityService;
import com.turkcell.TurkcellCRM.CoreService.filters.JwtAuthFilter;
import com.turkcell.TurkcellCRM.CoreService.jwt.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"com.turkcell.TurkcellCRM.CoreService.configuration"})
public class CustomerServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public BaseSecurityService baseSecurityService() {
        return new BaseSecurityService(new JwtAuthFilter(new JwtService()));
    }
    @Bean
    public JwtAuthFilter jwtAuthFilter(){
        return new JwtAuthFilter(new JwtService());
    }

}
