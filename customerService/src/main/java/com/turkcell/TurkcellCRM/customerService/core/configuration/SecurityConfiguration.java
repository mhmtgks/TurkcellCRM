package com.turkcell.TurkcellCRM.customerService.core.configuration;

import com.turkcell.TurkcellCRM.CoreService.configuration.BaseSecurityService;
import com.turkcell.TurkcellCRM.CoreService.filters.JwtAuthFilter;
import com.turkcell.TurkcellCRM.CoreService.jwt.JwtService;
import jakarta.servlet.FilterChain;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
//@RequiredArgsConstructor
public class SecurityConfiguration  {
    private JwtAuthFilter jwtAuthFilter;
//    @Autowired
    private final BaseSecurityService baseSecurityService;

    public SecurityConfiguration(BaseSecurityService baseSecurityService) {
        this.baseSecurityService = baseSecurityService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        baseSecurityService.configureCoreSecurity(http);
//        http.authorizeHttpRequests(x-> x

                http.authorizeHttpRequests(
                        (req)->req.requestMatchers("/customerservice/api/v1/customers").permitAll()
                );

//        );
        return http.build();
    }

}
