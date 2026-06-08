package com.project.aiSaas;


import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class user {

 
    // private final JdbcTemplate jdbcT ;
    
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
    public userModel postMethodName(@RequestBody userModel user) {
        
        //  sql queary 
//   String sql = "INSERT INTO users(user_name, numbers, email_id , passwords) VALUES (?, ?, ?, ?)";

//   jdbcT.update(sql  , user.getName() ,user.getNumbers() , user.getMail() , user.getPasswords());
repository.save(user);
  System.out.println(user.getName() );
  System.out.println(user.getPasswords());
        return user;
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

    
}
