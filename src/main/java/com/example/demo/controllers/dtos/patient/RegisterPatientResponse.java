package com.example.demo.controllers.dtos.patient;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterPatientResponse {
    private String message;

    @Override
    public String toString() {
        return message;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
