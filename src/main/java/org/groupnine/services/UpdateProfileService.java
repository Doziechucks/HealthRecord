package org.groupnine.services;


import org.groupnine.data.model.BodyType;
import org.groupnine.data.model.Gender;
import org.groupnine.data.model.Height;
import org.groupnine.dto.UpdateProfileDto;

import java.time.LocalDate;

public interface UpdateProfileService {
    void updateDoctorProfile(String userId, String firstname, String lastName, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth);
    void updateDoctorProfile(String userId, UpdateProfileDto updateProfileDto)

    void updatePatientProfile(String userId, UpdateProfileDto updateProfileDto);
}
