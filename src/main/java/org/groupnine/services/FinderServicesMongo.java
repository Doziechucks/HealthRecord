package org.groupnine.services;

import org.groupnine.data.model.*;
import org.groupnine.data.repositories.DoctorRepositoryMongo;
import org.groupnine.data.repositories.PatientRepositoryMongodb;

import java.time.LocalDate;

public class FinderServicesMongo implements FindersServices{
    private final PatientRepositoryMongodb patientRepository;
    private final DoctorRepositoryMongo doctorRepository;

    public FinderServicesMongo(PatientRepositoryMongodb patientRepository, PatientRepositoryMongodb profileRepository, DoctorRepositoryMongo doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Patient findPatientByUserId(String userId) {
        return patientRepository.findPatientByUserId(userId);
    }

    @Override
    public Patient findPatientByProfile(String firstname, String lastname, String email, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth) {
        Profile profile = new Profile();
        profileBuilder(firstname, lastname, email, height, bodyType, gender, dateOfBirth, profile);
        return (Patient) patientRepository.findPatientsByProfile(profile);
    }

    static void profileBuilder(String firstname, String lastname, String email, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth, Profile profile) {
        if(firstname != null) profile.setFirstname(firstname);
        if(lastname != null) profile.setLastname(lastname);
        if(email != null) profile.setEmail(email);
        if(height != null) profile.setHeight(height);
        if(bodyType != null) profile.setBodyType(bodyType);
        if(gender != null) profile.setGender(gender);
        if(dateOfBirth != null) profile.setDateOfBirth(dateOfBirth);
    }


    @Override
    public Patient findPatientByUsername(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public Doctor findDoctorByUserId(String userId) {
        return doctorRepository.findDoctorByUserId(userId);
    }

    @Override
    public Doctor findDoctorByProfile(String firstname, String lastname, String email, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth) {
        Profile profile = new Profile();
        profileBuilder(firstname, lastname, email, height, bodyType, gender, dateOfBirth, profile);
        return (Doctor) doctorRepository.findDoctorByProfile(profile);

    }


    @Override
    public Doctor findDoctorByUsername(String username) {
        return doctorRepository.findDoctorByUsername(username);
    }
}
