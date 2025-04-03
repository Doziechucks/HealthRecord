package org.groupnine.data.repositories;

import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DoctorRepository {
    Doctor save(Doctor doctor);
    Doctor findDoctorByUserId(String userId);
    List<Doctor> findAllDoctors();
    List<Doctor> findDoctorByProfile(Profile profile);
    boolean doctorExistsByUsername(String username);
    boolean doctorExistsByEmail(String email);
}
