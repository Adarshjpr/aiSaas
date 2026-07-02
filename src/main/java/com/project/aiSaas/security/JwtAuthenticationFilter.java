package com.project.aiSaas.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.aiSaas.utilty.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


@Autowired
private  JwtService jService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

             String authHeader =   request.getHeader("Authorization");
    
             System.out.println("auth " + authHeader);

//    auth header null   
//  authher bearr 


  String Token = authHeader.substring(7) ;

 String name  = jService.extrClaimsMail(Token);
      
 System.out.println(name);
// efkjsdkfjbsdkjfsdkjfsdjknsdklk
            
        //     VALIDATION 

filterChain.doFilter(request, response);





    }

}
