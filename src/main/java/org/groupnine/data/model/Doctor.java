package org.groupnine.data.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class Doctor extends User {
    private List<Appointment> appointments;

    public Doctor(int userId, String username, String password) {
        super(userId, username, password);
    }

    public Doctor(int userId, String username, String password, Profile profile) {
        super(userId, username, password, profile);
    }

    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

}
