package com.project.aiSaas.service.serviceLogic;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aiSaas.Dto.RequestDto.RequestUserDto;
import com.project.aiSaas.Dto.ResponseDto.ResponseUserDto;
import com.project.aiSaas.model.userModel;
import com.project.aiSaas.repository.Repository;
import com.project.aiSaas.service.servieInterface.UserInterface;

@Service
public class UserLogic implements UserInterface {

    @Autowired
 private Repository repository;



    @Override
 public  ResponseUserDto UserPost(RequestUserDto user) {
userModel  userM = new userModel();

userM.setName(user.getName());
userM.setMail(user.getMail());
userM.setNumbers(user.getNumbers());
userM.setPasswords(user.getPasswords());
repository.save(userM);
 
ResponseUserDto  responseUserDto = new ResponseUserDto();

responseUserDto.setMail(user.getMail());
responseUserDto.setName(user.getName());

    
  
  return responseUserDto ;
 }

}
