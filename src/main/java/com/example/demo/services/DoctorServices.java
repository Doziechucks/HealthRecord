package com.example.demo.services;


import com.example.demo.controllers.dtos.doctor.RegisterDoctorRequest;
import com.example.demo.controllers.dtos.doctor.RegisterDoctorResponse;
import com.example.demo.data.model.Doctor;
import com.example.demo.exception.EmailValidationException;
import com.example.demo.repositories.DoctorRepositories;
import org.springframework.stereotype.Service;

import static com.example.demo.utility.mapper.RegisterDoctorMapper.setDoctorMapper;
import static com.example.demo.utility.validation.RegisterDoctorValidation.validateDoctor;


@Service
public class DoctorServices {

    public DoctorRepositories repositories;

    public DoctorServices(DoctorRepositories repositories){
        this.repositories = repositories;
    }

    public RegisterDoctorResponse registerUser(RegisterDoctorRequest request){

        Doctor doctorEmail = repositories.findDoctorByEmail(request.getEmail());
        RegisterDoctorResponse response = new RegisterDoctorResponse();
        if(doctorEmail == null) {
            validateDoctor(request);
            Doctor doctor = setDoctorMapper(request);
            repositories.save(doctor);
            response.setMessage("Registered Doctor Successfully");
            return response;
        }
        if(request.getEmail().equalsIgnoreCase(doctorEmail.getEmail())) throw new EmailValidationException("User Already exists !!!");
        response.setMessage("An error occurred");
        return response;
    }
}
