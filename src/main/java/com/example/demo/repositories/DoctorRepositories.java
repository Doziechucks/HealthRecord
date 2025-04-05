package com.example.demo.repositories;

import com.example.demo.data.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepositories extends JpaRepository<Doctor,Long> {
    Doctor findDoctorByEmail(String email);

}
