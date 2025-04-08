package org.groupnine.services;

import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Patient;
import org.groupnine.data.repositories.DoctorRepositoryMongo;
import org.groupnine.data.repositories.PatientRepositoryMongodb;
import org.jetbrains.annotations.NotNull;

public class CreateAccountMongo implements CreateAccount {
    private final PatientRepositoryMongodb patientRepository;
    private final DoctorRepositoryMongo doctorRepository;

    public CreateAccountMongo(PatientRepositoryMongodb patientRepository, DoctorRepositoryMongo doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public String patientCreateAccount(@NotNull String username, String password) {
        if(username.isEmpty() || password.isEmpty() || password.contains(" ") || username.contains(" ")) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        if(patientRepository.findByUsername(username) == null) {
            Patient patient = new Patient(username, password);
            patientRepository.save(patient);
            return patient.getUserId();
        }
        else throw new IllegalArgumentException("this username already exists");
    }

    @Override
    public String doctorCreateAccount(String username, String password) {
        if(username.isEmpty() || password.isEmpty() || password.contains(" ") || username.contains(" ")) {
            throw new IllegalArgumentException("Invalid username or password");}
        if(doctorRepository.findDoctorByUsername(username) == null) {
            Doctor doctor = new Doctor(username, password);
            doctorRepository.save(doctor);
            return doctor.getUserId();
        }
        else throw new IllegalArgumentException("this username already exists");
    }

}
