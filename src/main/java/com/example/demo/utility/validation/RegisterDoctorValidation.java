package com.example.demo.utility.validation;
import java.util.regex.Pattern;
import com.example.demo.controllers.dtos.doctor.RegisterDoctorRequest;
import com.example.demo.controllers.dtos.patient.RegisterPatientRequest;
import com.example.demo.exception.EmailValidationException;

public class RegisterDoctorValidation {
    public static void validateDoctor(RegisterDoctorRequest request){
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isValid = Pattern.matches(emailRegex, request.getEmail());
        if (!isValid) throw new EmailValidationException("Invalid Details !!!");
    }

    public static void validatePatient(RegisterPatientRequest patientRequest){
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isValid = Pattern.matches(emailRegex,patientRequest.getEmail());

    }
}
