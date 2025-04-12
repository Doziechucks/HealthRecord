package org.groupnine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
public class BuilderDto {
    private String username;
    private String userId;
    private String userType;

    public BuilderDto(String username, String userId, String userType) {
        this.username = username;
        this.userId = userId;
        this.userType = userType;
    }
}

