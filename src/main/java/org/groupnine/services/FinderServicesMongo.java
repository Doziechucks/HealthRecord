package org.groupnine.services;

import org.groupnine.data.model.*;
import org.groupnine.data.repositories.DoctorRepositoryMongo;
import org.groupnine.data.repositories.PatientRepositoryMongodb;
import org.groupnine.dto.UpdateProfileDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FinderServicesMongo implements FindersServices{
    private final PatientRepositoryMongodb patientRepository;
    private final DoctorRepositoryMongo doctorRepository;

    public FinderServicesMongo(PatientRepositoryMongodb patientRepository, PatientRepositoryMongodb profileRepository, DoctorRepositoryMongo doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public String findPatientByUserId(String userId) {
        Patient patient = patientRepository.findPatientByUserId(userId);
        return patient != null ? patient.getUsername() : null;
    }


    @Override
    public List<String> findPatientByProfile(String firstname, String lastname, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth) {
        Profile profile = new Profile();
        profileBuilder(firstname, lastname, height, bodyType, gender, dateOfBirth, profile);
        List<Patient> patients = patientRepository.findPatientsByProfile(profile);
        if (patients == null) return null;
        return patients.stream()
                .map(Patient::getUserId)
                .collect(Collectors.toList());
    }

    static void profileBuilder(String firstname, String lastname, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth, Profile profile) {
        if(firstname != null) profile.setFirstname(firstname);
        if(lastname != null) profile.setLastname(lastname);
        if(height != null) profile.setHeight(height);
        if(bodyType != null) profile.setBodyType(bodyType);
        if(gender != null) profile.setGender(gender);
        if(dateOfBirth != null) profile.setDateOfBirth(dateOfBirth);
    }


    @Override
    public String findPatientByUsername(String username) {
        Patient patient = patientRepository.findByUsername(username);
        return patient != null ? patient.getUserId() : null;
    }

    @Override
    public String findDoctorByUserId(String userId) {
        Doctor doctor = doctorRepository.findDoctorByUserId(userId);
        return doctor != null ? doctor.getUsername() : null;
    }


    @Override
    public List<String> findDoctorByProfile(String firstname, String lastname, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth) {
        Profile profile = new Profile();
        profileBuilder(firstname, lastname, height, bodyType, gender, dateOfBirth, profile);
        List<Doctor> doctors = doctorRepository.findDoctorByProfile(profile);
        if (doctors == null) return null;
        return doctors.stream()
                .map(Doctor::getUserId)
                .collect(Collectors.toList());
    }
    public static void updateProfileFromDto(UpdateProfileDto dto, Profile profile) {
        if (dto.getFirstName() != null) profile.setFirstname(dto.getFirstName());
        if (dto.getLastName() != null) profile.setLastname(dto.getLastName());
        if (dto.getHeight() != null) profile.setHeight(dto.getHeight());
        if (dto.getBodyType() != null) profile.setBodyType(dto.getBodyType());
        if (dto.getGender() != null) profile.setGender(dto.getGender());
        if (dto.getDateOfBirth() != null) profile.setDateOfBirth(dto.getDateOfBirth());
    }


    @Override
    public String findDoctorByUsername(String username) {
        Doctor doctor = doctorRepository.findDoctorByUsername(username);
        return doctor != null ? doctor.getUserId() : null;
    }
}
