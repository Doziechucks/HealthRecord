package org.groupnine.data.repositories;

import org.groupnine.data.model.Patient;
import org.groupnine.data.model.Profile;

import java.util.List;

public interface PatientRepository {
    Patient save(Patient patient);
    Patient findPatientByUserId(String userId);
    List<Patient> findAllPatients();
    List<Patient> findPatientsByProfile(Profile profile);
    Patient findPatientByEmail(String email);
    Patient findByUsername(String username);
}
