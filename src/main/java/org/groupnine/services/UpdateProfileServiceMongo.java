package org.groupnine.services;

import org.groupnine.data.model.*;
import org.groupnine.data.repositories.DoctorRepositoryMongo;
import org.groupnine.data.repositories.PatientRepositoryMongodb;
import org.groupnine.dto.UpdateProfileDto;

import java.time.LocalDate;

public class UpdateProfileServiceMongo implements UpdateProfileService {
    private final PatientRepositoryMongodb patientRepository;
    private final DoctorRepositoryMongo doctorRepository;

    public UpdateProfileServiceMongo(PatientRepositoryMongodb patientRepository, DoctorRepositoryMongo doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }


    @Override
    public void updateDoctorProfile(String userId, UpdateProfileDto updateProfileDto) {
        Patient patient = patientRepository.findPatientByUserId(userId);
        if(patient == null) throw new IllegalArgumentException("Patient not found with id: " + userId);
        else{
        Profile profile = patient.getProfile();
        if (profile == null) {
            profile = new Profile();
            patient.setProfile(profile);

        }
            FinderServicesMongo.updateProfileFromDto(updateProfileDto, profile);
            patientRepository.save(patient);
        }
    }

    @Override
    public void updatePatientProfile(String userId, UpdateProfileDto updateProfileDto) {
        Doctor doctor = doctorRepository.findDoctorByUserId(userId);
        if(doctor == null) throw new IllegalArgumentException("Doctor not found with id: " + userId);
        else{
            Profile profile = doctor.getProfile();
            if (profile == null) {
                profile = new Profile();
                doctor.setProfile(profile);
            }
            FinderServicesMongo.updateProfileFromDto(updateProfileDto, profile);
            doctorRepository.save(doctor);
        }
    }

}
