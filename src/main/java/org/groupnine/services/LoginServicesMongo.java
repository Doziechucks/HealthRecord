package org.groupnine.services;

import org.groupnine.data.model.Patient;
import org.groupnine.data.repositories.DoctorRepositoryMongo;
import org.groupnine.data.repositories.PatientRepositoryMongodb;
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
    public boolean doctorLogin(String username, String password) {
        if(patientRepository.patientExistsByUsername(username)){
            Patient patient = patientRepository.findByUsername(username);
            return PasswordHash.verifyPassword(password, patient.getPassword());
        }
        throw new IllegalArgumentException("Invalid username");

    }

    @Override
    public boolean patientLogin(String username, String password) {
        if(doctorRepository.doctorExistsByUsername(username)){
            Patient patient = patientRepository.findByUsername(username);
            return PasswordHash.verifyPassword(password, patient.getPassword());
        }
        throw new IllegalArgumentException("Invalid username");
    }
}
