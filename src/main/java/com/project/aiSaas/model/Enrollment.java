package com.project.aiSaas.model;


import com.project.aiSaas.controller.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Enrollment {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
private String  id; 


private String Entrollment;


    @OneToOne
    @JoinColumn(name ="studentId"  ,  nullable =  false)
    private userModel studentId;

}
