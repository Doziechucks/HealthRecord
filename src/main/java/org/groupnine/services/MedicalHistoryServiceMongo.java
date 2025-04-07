package org.groupnine.services;

import org.groupnine.data.model.Patient;
import org.groupnine.data.repositories.DoctorRepository;
import org.groupnine.data.repositories.PatientRepository;

import java.util.List;

public class MedicalHistoryServiceMongo implements MedicalHistoryService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public MedicalHistoryServiceMongo(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }


    public void addToMedicalHistory(String userId, String medicalHistory){
        Patient patient = patientRepository.findPatientByUserId(userId);
        if(patient == null) throw new RuntimeException("Patient not found");
        else patient.addToMedicalRecords(medicalHistory);
    }

    @Override
    public List<String> getMedicalHistory(String userId, String medicalHistory) {
        Patient patient = patientRepository.findPatientByUserId(userId);
        if(patient == null) throw new RuntimeException("Patient not found");
        else return patient.getMedicalRecords();
    }

    @Override
    public String getPatientMedicalHistory(String userId) {
        StringBuilder history = new StringBuilder();
        Patient patient = patientRepository.findPatientByUserId(userId);
        if(patient == null) throw new RuntimeException("Patient not found");
        else {
            List<String> medicalHistory = patient.getMedicalRecords();
            for(String medicalRecord : medicalHistory){
                history.append(medicalRecord).append(".\n\n");
            }
        }
        return history.toString();
    }
}
