package org.groupnine.services;

import org.groupnine.data.model.*;
import org.groupnine.data.repositories.DoctorRepository;
import org.groupnine.data.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import java.time.LocalDate;
import java.util.List;

public class AppointmentServiceMongo implements AppointmentService {

    @Override
    public Patient findPatientByUserId(String userId) {
        return null;
    }

    @Override
    public Doctor findDoctorByUserId(String userId) {
        return null;
    }

    @Override
    public Patient findPatientByProfile(Profile profile) {
        return null;
    }

    @Override
    public Doctor findDoctorByProfile(Profile profile) {
        return null;
    }

    @Override
    public List<Appointment> findAppointmentsByPatientId(String patientId) {
        return List.of();
    }

    @Override
    public Appointment bookAppointment(String patientId, String doctorId, LocalDate date) {
        return null;
    }

    @Override
    public void cancelAppointment(String appointmentId) {

    }

    @Override
    public List<Appointment> findUpcomingAppointments(String patientId) {
        return List.of();
    }
}
