package com.project.aiSaas.repository;

import com.project.aiSaas.model.userModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repository extends JpaRepository<userModel , Integer >  {

// userModel  findbyname(String name) ;

//  DRIVEVATIV METHODS  = findbyname  findbyid  findbymail  findbynumbers  findbypasswords
@Query("select u from  userModel  u where u.id = :id" )
    Optional<userModel> findbyInegerId(Integer id);
}
