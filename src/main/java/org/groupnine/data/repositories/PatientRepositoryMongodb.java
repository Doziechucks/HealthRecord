package org.groupnine.data.repositories;

import org.groupnine.data.model.Patient;
import org.groupnine.data.model.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientRepositoryMongodb implements PatientRepository {
    private final MongoTemplate mongoTemplate;

    public PatientRepositoryMongodb(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Patient patient) {
        mongoTemplate.save(patient);
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
        if (profile == null) {
            return mongoTemplate.findAll(Patient.class);
        }
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();
        Optional.ofNullable(profile.getFirstname())
                .ifPresent(firstname -> criteriaList.add(Criteria.where("profile.firstname").is(firstname)));
        Optional.ofNullable(profile.getLastname())
                .ifPresent(lastname -> criteriaList.add(Criteria.where("profile.lastname").is(lastname)));
        Optional.ofNullable(profile.getGender())
                .ifPresent(gender -> criteriaList.add(Criteria.where("profile.gender").is(gender)));
        Optional.ofNullable(profile.getEmail())
                .ifPresent(email -> criteriaList.add(Criteria.where("profile.email").is(email)));
        Optional.ofNullable(profile.getBodyType())
                .ifPresent(bodyType -> criteriaList.add(Criteria.where("profile.bodyType").is(bodyType)));
        Optional.ofNullable(profile.getHeight())
                .ifPresent(height -> criteriaList.add(Criteria.where("profile.height").is(height)));
        if (criteriaList.isEmpty()) {
            return mongoTemplate.findAll(Patient.class);
        }
        else {
            Criteria combinedCriteria = new Criteria().orOperator(
                    new Criteria().andOperator(criteriaList.toArray(new Criteria[0])),
                    Criteria.where("profile").exists(false));
            query.addCriteria(combinedCriteria);
        }

        return mongoTemplate.find(query, Patient.class);
    }
}
