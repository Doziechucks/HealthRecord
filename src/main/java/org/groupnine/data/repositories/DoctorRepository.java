package org.groupnine.data.repositories;

import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Profile;

import java.util.List;

public interface DoctorRepository {
    public void save(Doctor doctor);
    public Doctor findDoctorByUserId(String userId);
    public List<Doctor> findAllDoctors();
    public List<Doctor> findDoctorByProfile(Profile profile);

}
