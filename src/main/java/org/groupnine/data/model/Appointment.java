package org.groupnine.data.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
public class Appointment {
    @BsonId
    @BsonProperty("appointment_id")
    private String appointmentId;
    @Setter
    private LocalDate date;
    @Setter
    private String patientId;
    @Setter
    private String doctorId;
    @Setter
    private String appointmentPurpose;

    public Appointment(LocalDate date ,String patientId, String doctorId, String appointmentPurpose) {
        this.date = date;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentPurpose = appointmentPurpose;
    }


}

