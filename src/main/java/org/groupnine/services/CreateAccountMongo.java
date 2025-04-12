package org.groupnine.services;

import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Patient;
import org.groupnine.data.repositories.DoctorRepositoryMongo;
import org.groupnine.data.repositories.PatientRepositoryMongodb;
import org.groupnine.dto.BuilderDto;
import org.jetbrains.annotations.NotNull;

public class CreateAccountMongo implements CreateAccount {
    private final PatientRepositoryMongodb patientRepository;
    private final DoctorRepositoryMongo doctorRepository;

    public CreateAccountMongo(PatientRepositoryMongodb patientRepository, DoctorRepositoryMongo doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public BuilderDto patientCreateAccount(
            @NotNull String username,
            @NotNull String password,
            @NotNull String email,
            @NotNull String firstName) {  // Added firstName parameter

        validateInput(username, password, email, firstName);
        checkExistingPatientCredentials(username, email);

        Patient newPatient = new Patient(username, password, email);
        patientRepository.save(newPatient);
        return new BuilderDto(newPatient.getUsername(), newPatient.getUserId(), "patient");
    }

    @Override
    public BuilderDto doctorCreateAccount(
    @NotNull String username,
    @NotNull String password,
    @NotNull String email,
    @NotNull String firstName) {

        validateInput(username, password, email, firstName);
        checkExistingDoctorCredentials(username, email);
        Doctor newDoctor = new Doctor(username, password);
        doctorRepository.save(newDoctor);
        return new BuilderDto(newDoctor.getUsername(), newDoctor.getUserId(), "doctor");
    }

    private void checkExistingDoctorCredentials(@NotNull String username, @NotNull String email) {
        if (doctorRepository.findDoctorByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (doctorRepository.findDoctorByUsername(email) != null) {
            throw new IllegalArgumentException("Email already registered");
        }
    }


    private void validateInput(String username, String password, String email, String firstName) {
        if (username == null || username.isEmpty() || username.contains(" ")) {
            throw new IllegalArgumentException("Username is Invalid");
        }

        if (password == null || password.isEmpty() || password.contains(" ")) {
            throw new IllegalArgumentException("password is Invalid");
        }

        if (email == null || email.isEmpty() || email.contains(" ")) {
            throw new IllegalArgumentException("email is Invalid");
        }

    }

    private void checkExistingPatientCredentials(String username, String email) {
        if (patientRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (patientRepository.findPatientByEmail(email) != null) {
            throw new IllegalArgumentException("Email already registered");
        }
    }

}
