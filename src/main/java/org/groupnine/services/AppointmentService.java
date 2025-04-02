package org.groupnine.services;

import org.groupnine.data.model.Appointment;
import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Patient;
import org.groupnine.data.model.Profile;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    Patient findPatientByUserId(String userId);
    Doctor findDoctorByUserId(String userId);
    Patient findPatientByProfile(Profile profile);
    Doctor findDoctorByProfile(Profile profile);

    List<Appointment> findAppointmentsByPatientId(String patientId);
    Appointment bookAppointment(String patientId, String doctorId, LocalDate date);
    void cancelAppointment(String appointmentId);
    List<Appointment> findUpcomingAppointments(String patientId);
}
