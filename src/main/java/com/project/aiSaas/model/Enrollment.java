package com.project.aiSaas.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.aiSaas.controller.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Enrollment {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
private String  id; 


private String Entrollment;


    @OneToOne
    @JsonIgnore
    @JoinColumn(name ="studentId"  ,  nullable =  false)
    private userModel studentId;

}
