package com.project.aiSaas;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class user {

 @GetMapping("/welcome")
    public String welcome(){

        return" welcome vivek" ;
    }
 
}
