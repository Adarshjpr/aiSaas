package com.project.aiSaas.service.serviceLogic;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aiSaas.Dto.RequestDto.RequestUserDto;
import com.project.aiSaas.Dto.ResponseDto.ResponseUserDto;
import com.project.aiSaas.model.Enrollment;
import com.project.aiSaas.model.Roles;
import com.project.aiSaas.model.userModel;
import com.project.aiSaas.repository.EnrollmentRepo;
import com.project.aiSaas.repository.Repository;
import com.project.aiSaas.service.servieInterface.UserInterface;
import com.project.aiSaas.utilty.JwtService;

import io.jsonwebtoken.Jwts.ENC;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserLogic implements UserInterface {

    private final JwtService jwtService;
  
 private final  Repository repository;
 private final EnrollmentRepo enrollmentRepo;


 



    @Override
 public  String UserPost(RequestUserDto user) {

 Roles role;
        try {
            role = Roles.valueOf(user.getRole().toUpperCase());
        } catch (Exception e) {
            role = Roles.USER;
        }
   userModel userModelSave =  userModel.builder().mail(user.getMail()).numbers(user.getNumbers()).name(user.getName()).passwords(user.getPasswords()).role(role).build();

   repository.save(userModelSave);
ResponseUserDto  responseUserDto = new ResponseUserDto();

responseUserDto.setMail(user.getMail());
responseUserDto.setName(user.getName());

   return JwtService.createToken(user.getMail(), user.getRole()) ;

 }


public userModel entrollment( Integer id){


      userModel u = repository.findbyInegerId(id).orElseThrow(()-> new RuntimeException("id not found"));
if (u.getEnrollment() ==null) {
    Enrollment e = Enrollment.builder().studentId(u).Entrollment("UC/26").build();
    enrollmentRepo.save(e);
    u.setEnrollment(e);
}else{
    System.out.println("  allready enrollment");
}


    return  u;
}



}
