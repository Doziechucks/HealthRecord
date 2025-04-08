package org.groupnine.services;

import org.groupnine.data.model.*;

import org.groupnine.data.repositories.DoctorRepositoryMongo;
import org.groupnine.data.repositories.PatientRepository;
import org.groupnine.data.repositories.PatientRepositoryMongodb;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public class AppointmentServiceMongo implements AppointmentService {
    private MongoTemplate mongoTemplate;
    private final PatientRepositoryMongodb patientRepository;
    private final DoctorRepositoryMongo doctorRepository;


    public AppointmentServiceMongo(PatientRepositoryMongodb patientRepository, DoctorRepositoryMongo doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }


    private Patient findPatientByUserId(String userId) {
        return patientRepository.findPatientByUserId(userId);
    }


    private Doctor findDoctorByUserId(String userId) {
        return doctorRepository.findDoctorByUserId(userId);
    }

    @Override
    public List<Appointment> findAppointmentsByUserId(String patientId) {
        Query query = new Query(Criteria.where("userId").is(patientId));
        return mongoTemplate.find(query, Appointment.class);

    }

    @Override
    public Appointment bookAppointment(String patientId, String doctorId, LocalDate date, String appointmentPurpose) {
        Patient patient = findPatientByUserId(patientId);
        Doctor doctor = findDoctorByUserId(doctorId);
        if (doctor == null){
            throw new IllegalArgumentException("Doctor not found");
        }
        else if (patient == null){
            throw new IllegalArgumentException("Patient not found");
        }
        Appointment appointment = new Appointment(
                UUID.randomUUID().toString(),
                date,
                patient.getUsername(),
                doctor.getUsername(),
                patient.getUserId(),
                doctor.getUserId(),
                appointmentPurpose
        );

        mongoTemplate.save(appointment);

        patient.getAppointments().add(appointment);
        mongoTemplate.save(patient);

        doctor.getAppointments().add(appointment);
        mongoTemplate.save(doctor);

        return appointment;
    }

    @Override
    public void cancelAppointment(String appointmentId) {
        Query query = new Query(Criteria.where("appointmentId").is(appointmentId));
        Appointment appointment = mongoTemplate.findOne(query, Appointment.class);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment not found");
        }
        mongoTemplate.remove(appointment);

        Patient patient = patientRepository.findPatientByUserId(appointment.getPatientId());
        if (patient != null) {
            patient.getAppointments().removeIf(a -> a.getAppointmentId().equals(appointmentId));
            patientRepository.save(patient);
        }
        Doctor doctor = doctorRepository.findDoctorByUserId(appointment.getDoctorId());
        if (doctor != null) {
            doctor.getAppointments().removeIf(a -> a.getAppointmentId().equals(appointmentId));
        }
    }

    @Override
    public String seePatientAppointments(String userId) {
        StringBuilder appointmentIds = new StringBuilder();
        Patient patient = patientRepository.findPatientByUserId(userId);
        if (patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }
        else {
            List<Appointment> appointments = patient.getAppointments();
            for (Appointment appointment : appointments) {
                appointmentIds.append(appointment.getAppointmentId()).append("\n");
            }
            return appointmentIds.toString();
        }
    }

    @Override
    public String seeDoctorAppointments(String userId) {
        StringBuilder appointmentIds = new StringBuilder();
        Doctor doctor = doctorRepository.findDoctorByUserId(userId);
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor not found");
        } else {
            List<Appointment> appointments = doctor.getAppointments();
            for (Appointment appointment : appointments) {
                appointmentIds.append(appointment.getAppointmentId()).append("\n");
            }
            return appointmentIds.toString();
        }

    }

    @Override
    public String seeAppointmentDetails(String userId, String appointmentId) {
        Doctor doctor = doctorRepository.findDoctorByUserId(userId);
        if (doctor == null) {
            Patient patient = patientRepository.findPatientByUserId(userId);
            if (patient == null) {
                throw new IllegalArgumentException("user not found");
            }
            else {
                List<Appointment> appointments = patient.getAppointments();
                for (Appointment appointment : appointments) {
                    if (appointment.getAppointmentId().equals(appointmentId)) {
                        return appointment.toString();
                    }
                }
            }
        }
        else{
            List<Appointment> appointments = doctor.getAppointments();
            for (Appointment appointment : appointments) {
                if (appointment.getAppointmentId().equals(appointmentId)) {
                    return appointment.toString();
                }
            }
        }
        return "no appointment has this appointment ID";
    }

}


