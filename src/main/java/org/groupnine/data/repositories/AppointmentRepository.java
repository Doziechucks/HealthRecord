package org.groupnine.data.repositories;

import org.groupnine.data.model.Appointment;

import java.util.List;

public interface AppointmentRepository {
    String saveAppointment(Appointment appointment);
    List<Appointment> getAppointments();
    List<Appointment> getAppointmentsByUserId(String userId);
    String deleteAppointment(String appointmentId);
    Appointment getAppointment(String appointmentId);
}
