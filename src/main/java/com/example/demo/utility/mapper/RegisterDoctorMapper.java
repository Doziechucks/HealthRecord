package com.example.demo.utility.mapper;

import com.example.demo.controllers.dtos.doctor.RegisterDoctorRequest;
import com.example.demo.data.model.Doctor;

public class RegisterDoctorMapper {
    public static Doctor setDoctorMapper(RegisterDoctorRequest request){
        Doctor doctor = new Doctor();
        doctor.setFirstname(request.getFirstName());
        doctor.setLastname(request.getLastname());
        doctor.setUsername(request.getUsername());
        doctor.setEmail(request.getEmail());
        doctor.setPassword(request.getPassword());
        return doctor;
    }
}
