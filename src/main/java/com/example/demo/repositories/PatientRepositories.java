package com.example.demo.repositories;

import com.example.demo.data.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepositories extends JpaRepository<Patients,Long> {

}
