package org.groupnine.data.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class Patient extends User{
    private List<String> medicalRecords;
    private List<Appointment> appointments;

    public Patient(int userId, String username, String password) {
        super(userId, username, password);
    }

    public Patient(int userId, String username, String password, Profile profile) {
        super(userId, username, password, profile);
    }

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }
}

