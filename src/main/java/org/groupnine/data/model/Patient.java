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


    public Patient( String username, String password, String email) {
        super(username, password, email);
    }

    public Patient(String username, String password, String email, Profile profile) {
        super(username, password, email, profile);
    }

    public void addToMedicalRecords(String medicalRecord) {
        medicalRecords.add(medicalRecord);
    }
}

