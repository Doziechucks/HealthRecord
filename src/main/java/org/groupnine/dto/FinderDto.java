package org.groupnine.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.groupnine.data.model.BodyType;
import org.groupnine.data.model.Gender;
import org.groupnine.data.model.Height;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class FinderDto {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private BodyType bodyType;
    private Height height;
    private Gender gender;
}
