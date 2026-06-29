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

    @Autowired
 private Repository repository;



    @Override
 public  ResponseUserDto UserPost(RequestUserDto user) {


 userModel.builder().mail(user.getMail()).numbers(user.getNumbers()).name(user.getName()).passwords(user.getPasswords()).build();
ResponseUserDto  responseUserDto = new ResponseUserDto();

responseUserDto.setMail(user.getMail());
responseUserDto.setName(user.getName());

    JwtService.createToken(user.getMail());
  
  return responseUserDto ;
 }

}
