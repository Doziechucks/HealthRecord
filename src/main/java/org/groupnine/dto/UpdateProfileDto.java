package org.groupnine.dto;

import lombok.Getter;
import lombok.Setter;
import org.groupnine.data.model.BodyType;
import org.groupnine.data.model.Gender;
import org.groupnine.data.model.Height;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Setter @Getter
public class UpdateProfileDto {
    private String firstName;
    private String lastName;
    private Height height;
    private BodyType bodyType;
    private Gender gender;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    public UpdateProfileDto(String firstName, String lastName, Height height, BodyType bodyType, Gender gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.bodyType = bodyType;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;

    }
}
