package com.example.demo.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Profile {
    private String firstname;
    private String lastname;
    private String email;
    private Height height;
    private BodyType bodyType;

}
