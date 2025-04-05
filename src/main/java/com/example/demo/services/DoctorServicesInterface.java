package com.example.demo.services;

import com.example.demo.controllers.dtos.doctor.RegisterDoctorRequest;
import com.example.demo.controllers.dtos.doctor.RegisterDoctorResponse;
import org.springframework.stereotype.Service;

@Service
public interface DoctorServicesInterface {
    RegisterDoctorResponse registerUser(RegisterDoctorRequest request);
}
