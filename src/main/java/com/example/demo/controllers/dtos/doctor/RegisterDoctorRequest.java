package com.example.demo.controllers.dtos.doctor;

import com.example.demo.data.model.Profile;
import com.example.demo.data.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDoctorRequest extends User {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
