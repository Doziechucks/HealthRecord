package org.groupnine.services;


import org.groupnine.data.model.BodyType;
import org.groupnine.data.model.Gender;
import org.groupnine.data.model.Height;

import java.time.LocalDate;

public interface UpdateProfileService {
    void updateDoctorProfile(String userId, String firstname, String lastName, String email, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth);
    void updatePatientProfile(String userId, String firstname, String lastName, String email,Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth);

}
