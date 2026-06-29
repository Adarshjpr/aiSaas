package com.project.aiSaas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration     // con
@EnableWebSecurity   // 
public class SecurityConfig {
    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity request){

    System.out.println("request for a user " + request);
request.csrf(csrf -> csrf.disable())
  .authorizeHttpRequests(auth -> auth.requestMatchers("/public/**").permitAll()
  .requestMatchers("/private/**").authenticated()
  
  ) .httpBasic(Customizer.withDefaults());
return request.build();
}



}
