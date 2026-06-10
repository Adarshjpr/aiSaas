package com.project.aiSaas.service.servieInterface;



import org.springframework.stereotype.Service;

import com.project.aiSaas.Dto.RequestDto.RequestUserDto;
import com.project.aiSaas.Dto.ResponseDto.ResponseUserDto;

@Service
public interface UserInterface {

    ResponseUserDto UserPost( RequestUserDto user) ;
    
}