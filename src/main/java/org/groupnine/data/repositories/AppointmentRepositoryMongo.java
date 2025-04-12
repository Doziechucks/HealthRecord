package org.groupnine.data.repositories;

import org.groupnine.data.model.Appointment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mongoAppointmentRepository")
public class AppointmentRepositoryMongo implements AppointmentRepository {
    private final MongoTemplate mongoTemplate;

    public AppointmentRepositoryMongo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public String saveAppointment(Appointment appointment) {
        mongoTemplate.save(appointment);
        return appointment.getAppointmentId();
    }

    @Override
    public List<Appointment> getAppointments() {
        return mongoTemplate.findAll(Appointment.class);
    }

    @Override
    public List<Appointment> getAppointmentsByUserId(String userId) {
        return mongoTemplate.findAll(Appointment.class, userId);
    }

    @Override
    public String deleteAppointment(String appointmentId) {
        Appointment appointment = mongoTemplate.findById(appointmentId, Appointment.class);
        if (appointment != null) {
            mongoTemplate.remove(appointment);
            return appointment.getAppointmentId();
        }
        else throw new IllegalArgumentException("Appointment not found");
    }

    @Override
    public Appointment getAppointment(String appointmentId) {
        return mongoTemplate.findById(appointmentId, Appointment.class);
    }
}
