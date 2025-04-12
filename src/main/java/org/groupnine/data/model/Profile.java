package org.groupnine.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Profile {
    private String firstname;
    private String lastname;
    private Height height;
    private BodyType bodyType;
    private Gender gender;
    private LocalDate dateOfBirth;
}


