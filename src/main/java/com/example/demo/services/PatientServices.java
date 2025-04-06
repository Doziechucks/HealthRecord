package com.example.demo.services;

import com.example.demo.controllers.dtos.doctor.RegisterDoctorResponse;
import com.example.demo.controllers.dtos.patient.RegisterPatientRequest;
import com.example.demo.controllers.dtos.patient.RegisterPatientResponse;
import com.example.demo.data.model.Patients;
import com.example.demo.exception.EmailValidationException;
import com.example.demo.repositories.PatientRepositories;
import org.springframework.stereotype.Service;

import static com.example.demo.utility.mapper.RegisterPatientMapper.setPatientMapper;
import static com.example.demo.utility.validation.RegisterDoctorValidation.validatePatient;

@Service
public class PatientServices {

    public PatientRepositories patientRepositories;

    public PatientServices(PatientRepositories patientRepositories) {
        this.patientRepositories = patientRepositories;
    }

    public RegisterPatientResponse registerPatient(RegisterPatientRequest patientRequest){

        Patients patientsEmail = patientRepositories.findPatientsByEmail(patientRequest.getEmail());
        RegisterPatientResponse patientResponse = new RegisterPatientResponse();
        if(patientsEmail == null){
            validatePatient(patientRequest);
            Patients patients = setPatientMapper(patientRequest);
            patientRepositories.save(patients);
            patientResponse.setMessage("Registered Patient Successfully");
            return patientResponse;
        }
        if(patientRequest.getEmail().equalsIgnoreCase(patientsEmail.getEmail())) throw new EmailValidationException("User Already exists !!!") ;
        patientResponse.setMessage("An error occurred");
        return patientResponse;

    }
}
