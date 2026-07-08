package com.project.aiSaas.Dto.RequestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestUserDto {

@NotBlank(message = "Username cannot be blank")
     private String name;    //   usernams varchar(255)

     @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
  private String mail;     // mail varchar(255) unquie 

  private String role;
  private String  passwords;  // passwords  varchar(255)  not null
  
  private String  numbers;

}
