package com.example.demo.controllers.dtos.doctor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDoctorResponse {
    private String message;

    @Override
    public String toString() {
        return message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
