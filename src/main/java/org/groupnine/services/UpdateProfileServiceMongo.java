package org.groupnine.services;

import org.groupnine.data.model.*;
import org.groupnine.data.repositories.DoctorRepositoryMongo;
import org.groupnine.data.repositories.PatientRepositoryMongodb;
import org.springframework.security.access.method.P;

import java.time.LocalDate;

public class UpdateProfileServiceMongo implements UpdateProfileService {
    private final PatientRepositoryMongodb patientRepository;
    private final DoctorRepositoryMongo doctorRepository;

    public UpdateProfileServiceMongo(PatientRepositoryMongodb patientRepository, DoctorRepositoryMongo doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void updateDoctorProfile(String userId, String firstname, String lastname, String email, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth) {
        Patient patient = patientRepository.findPatientByUserId(userId);
        if(patient == null) throw new IllegalArgumentException("Patient not found with id: " + userId);
        else{
        Profile profile = patient.getProfile();
        if (profile == null) {
            profile = new Profile();
            patient.setProfile(profile);
        }
            FinderServicesMongo.profileBuilder(firstname, lastname, email, height, bodyType, gender, dateOfBirth, profile);

            patientRepository.save(patient);
        }
    }

    @Override
    public void updatePatientProfile(String userId, String firstName, String lastName, String email, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth) {
        Doctor doctor = doctorRepository.findDoctorByUserId(userId);
        if(doctor == null) throw new IllegalArgumentException("Doctor not found with id: " + userId);
        else{
            Profile profile = doctor.getProfile();
            if (profile == null) {
                profile = new Profile();
                doctor.setProfile(profile);
            }
            FinderServicesMongo.profileBuilder(firstName, lastName, email, height, bodyType, gender, dateOfBirth, profile);

            doctorRepository.save(doctor);
        }
    }

}
