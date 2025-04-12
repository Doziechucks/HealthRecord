package org.groupnine.services;

import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Patient;
import org.groupnine.data.repositories.DoctorRepositoryMongo;
import org.groupnine.data.repositories.PatientRepositoryMongodb;
import org.groupnine.dto.BuilderDto;
import org.groupnine.security.PasswordHash;
import org.springframework.data.mongodb.core.MongoTemplate;

public class LoginServicesMongo implements LoginServices {
    private final DoctorRepositoryMongo doctorRepository;
    private final PatientRepositoryMongodb patientRepository;
    private MongoTemplate mongoTemplate;

    public LoginServicesMongo(DoctorRepositoryMongo doctorRepository, PatientRepositoryMongodb patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }



    @Override
    public BuilderDto doctorLogin(String username, String password) {
        Doctor doctor = doctorRepository.findDoctorByUsername(username);
        if (doctor != null && PasswordHash.verifyPassword(password, doctor.getPassword())) {
            return new BuilderDto(username, doctor.getUserId(), "doctor");
        }
        throw new IllegalArgumentException("Invalid credentials");
    }

    @Override
    public BuilderDto patientLogin(String username, String password) {
        Patient patient = patientRepository.findByUsername(username);
        if (patient != null && PasswordHash.verifyPassword(password, patient.getPassword())) {
            return new BuilderDto(username, patient.getUserId(), "patient");
        }
        throw new IllegalArgumentException("Invalid credentials");
    }
}
