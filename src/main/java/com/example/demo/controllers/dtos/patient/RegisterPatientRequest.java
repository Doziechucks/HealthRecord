package com.example.demo.controllers.dtos.patient;

import com.example.demo.data.model.BodyType;
import com.example.demo.data.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterPatientRequest extends User {
    private BodyType bodyType;
}
