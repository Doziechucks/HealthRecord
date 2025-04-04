package com.example.demo.data.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {
    private int userId;
    private String username;
    private String password;
    private Profile profile;
}
