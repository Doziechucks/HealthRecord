package com.example.demo.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class User {
    private int userId;
    private String username;
    private String password;
    private Profile profile;
}
