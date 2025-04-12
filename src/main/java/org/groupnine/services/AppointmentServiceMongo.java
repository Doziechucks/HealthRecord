package org.groupnine.services;

import org.groupnine.data.model.*;

import org.springframework.data.mongodb.core.MongoTemplate;
import java.time.LocalDate;

import org.groupnine.data.repositories.AppointmentRepository;


public class AppointmentServiceMongo implements AppointmentService {
    private MongoTemplate mongoTemplate;
    private final AppointmentRepository appointmentRepository;


    public AppointmentServiceMongo(AppointmentRepository appointmentRepository) {

        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public String bookAppointment(String patientId, String doctorId, LocalDate date, String appointmentPurpose) {
        Appointment appointment = new Appointment(
                date,
                patientId,
                doctorId,
                appointmentPurpose
        );
        return appointmentRepository.saveAppointment(appointment);
    }

    @Override
    public String cancelAppointment(String appointmentId) {
        return appointmentRepository.deleteAppointment(appointmentId);
    }

    @Override
    public String seeUserAppointments(String userId) {
        StringBuilder appointmentIds = new StringBuilder();
        for(Appointment appointment: appointmentRepository.getAppointmentsByUserId(userId)) {
            appointmentIds.append(appointment.getAppointmentId()).append("\n");
        }
        return appointmentIds.toString();
    }


    @Override
    public Appointment seeAppointmentDetails(String appointmentId) {
        for(Appointment appointment: appointmentRepository.getAppointments()){
            if(appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }
        return null;
    }


}


