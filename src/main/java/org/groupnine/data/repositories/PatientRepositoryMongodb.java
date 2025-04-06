package org.groupnine.data.repositories;

import org.groupnine.data.model.Patient;
import org.groupnine.data.model.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("mongoPatientRepository")
public class PatientRepositoryMongodb implements PatientRepository {
    private final MongoTemplate mongoTemplate;

    public PatientRepositoryMongodb(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Patient save(Patient patient) {
        mongoTemplate.save(patient);
        return patient;
    }

    @Override
    public Patient findPatientByUserId(String userId) {
        Query query = new Query(Criteria.where("user_id").is(userId));
        return mongoTemplate.findOne(query, Patient.class);
    }

    @Override
    public List<Patient> findAllPatients() {
        return mongoTemplate.findAll(Patient.class);
    }

    @Override
    public List<Patient> findPatientsByProfile(Profile profile) {
        Query query = DoctorRepositoryMongo.buildProfileQuery(profile);
        return mongoTemplate.find(query, Patient.class);

    }

    @Override
    public boolean patientExistsByUsername(String username) {
        return mongoTemplate.exists(
                Query.query(Criteria.where("username").is(username)),
                Patient.class
        );
    }

    @Override
    public boolean patientExistsByEmail(String email) {
        return mongoTemplate.exists(
                Query.query(
                        new Criteria().andOperator(
                                Criteria.where("profile").exists(true),
                                Criteria.where("profile.email").is(email)
                        )
                ),
                Patient.class
        );

    }

    @Override
    public Patient findByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query, Patient.class);
    }




}
