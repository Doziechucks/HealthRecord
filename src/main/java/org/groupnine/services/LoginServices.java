package org.groupnine.services;

public interface LoginServices {


    boolean doctorLogin(String username, String password);
    boolean patientLogin(String username, String password);
}
