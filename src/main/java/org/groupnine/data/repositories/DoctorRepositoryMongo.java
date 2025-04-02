package org.groupnine.data.repositories;

import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Patient;
import org.groupnine.data.model.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorRepositoryMongo implements DoctorRepository {
    private final MongoTemplate mongoTemplate;

    public DoctorRepositoryMongo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Doctor doctor) {
        mongoTemplate.save(doctor);
    }

    @Override
    public Doctor findDoctorByUserId(String userId) {
        Query query = Query.query(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, Doctor.class);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        return mongoTemplate.findAll(Doctor.class);
    }

    @Override
    public List<Doctor> findDoctorByProfile(Profile profile) {
        if (profile == null) {
            return mongoTemplate.findAll(Doctor.class);
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
            return mongoTemplate.findAll(Doctor.class);
        }
        else {
            return mongoTemplate.find(query, Doctor.class);
        }
    }
}
