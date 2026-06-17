package com.project.aiSaas.service.servieInterface;





import com.project.aiSaas.Dto.RequestDto.RequestUserDto;
import com.project.aiSaas.Dto.ResponseDto.ResponseUserDto;


public interface UserInterface {

    ResponseUserDto UserPost( RequestUserDto user) ;
    

}