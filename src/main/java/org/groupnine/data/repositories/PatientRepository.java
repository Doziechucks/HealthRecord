package org.groupnine.data.repositories;

import org.groupnine.data.model.Patient;
import org.groupnine.data.model.Profile;

import java.util.List;

public interface PatientRepository {
    public void save(Patient patient);
    public Patient findPatientByUserId(String userId);
    public List<Patient> findAllPatients();
    public List<Patient> findPatientsByProfile(Profile profile);
}
