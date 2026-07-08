package com.project.aiSaas.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.aiSaas.security.JwtAuthenticationFilter;

@Configuration     // con
@EnableWebSecurity   // 
public class SecurityConfig {
 private final JwtAuthenticationFilter jFilter;
    SecurityConfig( JwtAuthenticationFilter jFilter){
this.jFilter =jFilter ;
    }

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity request) throws Exception{

  

    System.out.println("request for a user " + request);
request.csrf(csrf -> csrf.disable())
  .authorizeHttpRequests(auth -> auth.requestMatchers("/public/**").permitAll()
  .requestMatchers("/admin/**").hasRole("ADMIN")
    .requestMatchers("/user/**").hasRole("USER")
  .requestMatchers("/private/**").authenticated()
  
  ) .httpBasic(Customizer.withDefaults())
  .addFilterBefore(jFilter ,  UsernamePasswordAuthenticationFilter.class);
return request.build();
}



}
