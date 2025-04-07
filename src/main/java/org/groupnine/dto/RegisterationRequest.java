package org.groupnine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterationRequest {
    private String username;
    private String password;

    public RegisterationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
