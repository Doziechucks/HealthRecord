package org.groupnine.services;

import org.groupnine.data.model.Appointment;
import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Patient;
import org.groupnine.data.model.Profile;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    String bookAppointment(String patientId, String doctorId, LocalDate date, String appointmentPurpose);
    String cancelAppointment(String appointmentId);
    String seeUserAppointments(String userId);
    Appointment seeAppointmentDetails(String appointmentId);
}
