package com.project.aiSaas.controller;


import java.util.List;
import java.util.Optional;

import com.project.aiSaas.Dto.RequestDto.RequestUserDto;
import com.project.aiSaas.Dto.ResponseDto.ResponseUserDto;
import com.project.aiSaas.model.userModel;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.aiSaas.repository.Repository;
import com.project.aiSaas.service.serviceLogic.UserLogic;
import com.project.aiSaas.service.servieInterface.UserInterface;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class user {

 
    // private final JdbcTemplate jdbcT ;
    // @Autowired
// private UserInterface userInterface;

@Autowired
private   UserLogic userLogic;
    private final  Repository repository ;
    //  CONSTRUCTORE INJECT  
    //  user(JdbcTemplate jdbcT    ){
    //     this.jdbcT = jdbcT; 
    //  }

      user(Repository repository){
        this.repository = repository ;
      }

 @GetMapping("/welcome")
    public String welcome(){

        return" welcome vivek" ;
    }
 
    

    @PostMapping("/register")
    public ResponseUserDto  postMethodName( @Valid   @RequestBody RequestUserDto user) {
        
        //  sql queary 
//   String sql = "INSERT INTO users(user_name, numbers, email_id , passwords) VALUES (?, ?, ?, ?)";

//   jdbcT.update(sql  , user.getName() ,user.getNumbers() , user.getMail() , user.getPasswords());

        return userLogic.UserPost(user);
    }
    

//  get api 

@GetMapping("/get/{id}")
public List<userModel> getMethodName(  @PathVariable Integer id ) {
   
 return  repository.findAll();

}


@DeleteMapping("/delete/{id}")
public String  Deletedata(@PathVariable  Integer id){
  
repository.deleteById(id);

  return "success fulli  delete " ;
} 

    

@PutMapping("path/{id}")
public  String  putMethodName(@PathVariable Integer id, @RequestBody userModel RequestUser) {

//  sab se phele to mujhe fetch karni chaiye 
// vivek patwa , 89898 , 68 ,

// repository.save(user);   /// save 

 Optional<userModel> users=   repository.findById(id) ;
        
 
 if (users.isPresent()) {
   
  userModel  person =    users.get();
   
  person.setMail(RequestUser.getMail());
  person.setName(RequestUser.getName());
  person.setNumbers(RequestUser.getNumbers());
  person.setPasswords(RequestUser.getPasswords());
  repository.save(person);
 }


/*
old 
{
    "mail": "rahul@gmail.com",  || rahulkumer@gmail.com 
    "name": "Rahul Kumar",
    "numbers": "9876543210",  || 676767676766 
    "passwords": "rahul123"
}

new 



{ real 
    "mail": "rahulkumer@gmail.com",
    "name": "Rahul Kumar",
    "numbers": "676767676766",
    "passwords": "rahul123"
}

*/




// {

//   name : "vivke patwa",
//   number : 8989,
//   age : 21,
// }
return " VALUE UPDATE SUCCESSFUL " ;

}




}
























