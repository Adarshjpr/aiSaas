package com.project.aiSaas.service.serviceLogic;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aiSaas.Dto.RequestDto.RequestUserDto;
import com.project.aiSaas.Dto.ResponseDto.ResponseUserDto;
import com.project.aiSaas.model.userModel;
import com.project.aiSaas.repository.Repository;
import com.project.aiSaas.service.servieInterface.UserInterface;
import com.project.aiSaas.utilty.JwtService;

@Service
public class UserLogic implements UserInterface {

    private final JwtService jwtService;
    @Autowired
 private Repository repository;



    UserLogic(JwtService jwtService) {
        this.jwtService = jwtService;
    }



    @Override
 public  String UserPost(RequestUserDto user) {


 userModel.builder().mail(user.getMail()).numbers(user.getNumbers()).name(user.getName()).passwords(user.getPasswords()).build();
ResponseUserDto  responseUserDto = new ResponseUserDto();

responseUserDto.setMail(user.getMail());
responseUserDto.setName(user.getName());

   return JwtService.createToken(user.getMail(), user.getRole()) ;

 }

}
