package com.project.aiSaas.repository;

import com.project.aiSaas.model.userModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<userModel , Integer >  {

// userModel  findbyname(String name) ;

//  DRIVEVATIV METHODS  = findbyname  findbyid  findbymail  findbynumbers  findbypasswords
}
