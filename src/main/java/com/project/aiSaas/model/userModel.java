package com.project.aiSaas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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


  // 

}
