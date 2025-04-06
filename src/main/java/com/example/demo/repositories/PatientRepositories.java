package com.example.demo.repositories;

import com.example.demo.data.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositories extends JpaRepository<Patients,Long> {
    Patients findPatientsByEmail(String email);
}
