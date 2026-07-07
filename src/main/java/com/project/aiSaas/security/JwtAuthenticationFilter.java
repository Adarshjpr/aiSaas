package com.project.aiSaas.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

@Autowired
private UserDetailsService  userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        String email = jService.extrClaimsMail(token);

        if(email !=null && SecurityContextHolder.getContext().getAuthentication()== null){


            UserDetails userDetails =  userDetailsService.loadUserByUsername(email);
            //  select * from  where email = ?
//  username  , user role

 UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(userDetails , null , userDetails.getAuthorities());


SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }



        filterChain.doFilter(request, response);
    }

}
