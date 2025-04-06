package com.example.demo.utility.mapper;

import com.example.demo.controllers.dtos.patient.RegisterPatientRequest;
import com.example.demo.data.model.Patients;

public class RegisterPatientMapper {

    public static Patients setPatientMapper(RegisterPatientRequest patientRequest){
        Patients patients = new Patients();
        patients.setFirstname(patientRequest.getFirstname());
        patients.setLastname(patientRequest.getLastname());
        patients.setUsername(patientRequest.getUsername());
        patients.setPassword(patientRequest.getPassword());
        patients.setEmail(patientRequest.getEmail());
        patients.setId(patientRequest.getId());
        patients.setHeight(patientRequest.getHeight());
        patients.setBodyType(patientRequest.getBodyType());
        patients.setGender(patientRequest.getGender());
        return patients;
    }
}
