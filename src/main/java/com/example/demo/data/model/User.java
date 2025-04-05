package com.example.demo.data.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class User extends Profile{
    private int userId;
    private String username;
    private Object password;
    @OneToOne
    private Profile profile;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password){
        this.password = password;
    }

    public Profile getProfile(){
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
