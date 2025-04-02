package org.groupnine.data.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

@Setter @Getter
public class Doctor extends User {

    @BsonProperty("appointments")
    private List<Appointment> appointments;

    public Doctor(String userId, String username, String password) {
        super(userId, username, password);
    }

    public Doctor(String userId, String username, String password, Profile profile) {
        super(userId, username, password, profile);
    }


    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }


}
