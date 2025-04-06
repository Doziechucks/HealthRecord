package org.groupnine.services;

import org.groupnine.data.model.*;

import java.time.LocalDate;

public interface FindersServices {
    Patient findPatientByUserId(String userId);
    Patient findPatientByProfile(String firstname, String lastname, String email, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth);
    Patient findPatientByUsername(String username);
    Doctor findDoctorByUserId(String userId);
    Doctor findDoctorByProfile(String firstname, String lastname, String email, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth);
    Doctor findDoctorByUsername(String username);

}
