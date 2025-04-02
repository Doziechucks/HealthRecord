package org.groupnine.data.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;


import java.util.ArrayList;
import java.util.List;

@Setter @Getter
public class Patient extends User{

    @BsonProperty("medical_records")
    private List<String> medicalRecords = new ArrayList<>();

    @BsonProperty("appointments")
    private List<Appointment> appointments = new ArrayList<>();

    public Patient(String userId, String username, String password) {
        super(userId, username, password);
    }

    public Patient(String userId, String username, String password, Profile profile) {
        super(userId, username, password, profile);
    }

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }
}

