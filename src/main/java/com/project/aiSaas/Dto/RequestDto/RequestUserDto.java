package com.project.aiSaas.Dto.RequestDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class RequestUserDto {

@NotBlank(message = "Username cannot be blank")
     private String name;    //   usernams varchar(255)

     @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
  private String mail;     // mail varchar(255) unquie 

  private String  passwords;  // passwords  varchar(255)  not null
  
  private String  numbers;
  public RequestUserDto() {
  }
  public RequestUserDto(String name, String mail, String passwords, String numbers) {
    this.name = name;
    this.mail = mail;
    this.passwords = passwords;
    this.numbers = numbers;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getMail() {
    return mail;
  }
  public void setMail(String mail) {
    this.mail = mail;
  }
  public String getPasswords() {
    return passwords;
  }
  public void setPasswords(String passwords) {
    this.passwords = passwords;
  }
  public String getNumbers() {
    return numbers;
  }
  public void setNumbers(String numbers) {
    this.numbers = numbers;
  } 
}
