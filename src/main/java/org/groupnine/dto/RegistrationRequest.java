package org.groupnine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegistrationRequest {
    private String username;
    private String password;
    private String email;

    public RegistrationRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


}
