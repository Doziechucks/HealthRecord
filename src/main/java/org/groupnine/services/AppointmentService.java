package org.groupnine.services;

import org.groupnine.data.model.Appointment;
import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Patient;
import org.groupnine.data.model.Profile;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {


    List<Appointment> findAppointmentsByUserId(String userId);
    Appointment bookAppointment(String patientId, String doctorId, LocalDate date, String appointmentPurpose);
    void cancelAppointment(String appointmentId);
    String seePatientAppointments(String userId);
    String seeDoctorAppointments(String userId);
    String seeAppointmentDetails(String userId, String appointmentId);
}
