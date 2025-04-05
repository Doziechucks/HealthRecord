package com.example.demo.controllers.dtos.doctor;


public class LoginDoctorRequest {
    private String userName;
    private Object password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }
}
