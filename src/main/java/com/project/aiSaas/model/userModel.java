package com.project.aiSaas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class userModel {

//   koi bhi table bana rahe ho to usme primary key 


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id ;


@Column(name = "usernames" )
  private String name;    //   usernams varchar(255)
  @Column(unique = true )
  private String mail;     // mail varchar(255) unquie 
  @Column(nullable = false)
  private String  passwords;  // passwords  varchar(255)  not null
  private String  numbers;    //  numbers varchar(255)

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
