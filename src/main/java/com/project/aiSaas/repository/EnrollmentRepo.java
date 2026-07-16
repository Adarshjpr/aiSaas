package com.project.aiSaas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.aiSaas.model.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment , String > {

}
