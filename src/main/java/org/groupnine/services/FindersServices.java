package org.groupnine.services;

import org.groupnine.data.model.*;
import org.groupnine.dto.FinderDto;

import java.time.LocalDate;
import java.util.List;

public interface FindersServices {
    String findPatientByUserId(String userId);
    List<String> findPatientByProfile(String firstname, String lastname, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth);
    String findPatientByUsername(String username);
    String  findDoctorByUserId(String userId);
    List<String>  findDoctorByProfile(String firstname, String lastname, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth);
    String findDoctorByUsername(String username);

}
