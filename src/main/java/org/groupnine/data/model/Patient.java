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

    public Patient( String username, String password) {
        super(username, password);
    }

    public Patient(String username, String password, Profile profile) {
        super(username, password, profile);
    }

    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }
    public void addToMedicalRecords(String medicalRecord) {
        medicalRecords.add(medicalRecord);
    }
}

