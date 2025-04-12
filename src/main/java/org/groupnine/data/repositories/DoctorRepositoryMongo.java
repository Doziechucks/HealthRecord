package org.groupnine.data.repositories;

import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("mongoDoctorRepository")
public class DoctorRepositoryMongo implements DoctorRepository {
    private final MongoTemplate mongoTemplate;

    public DoctorRepositoryMongo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Doctor save(Doctor doctor) {
        mongoTemplate.save(doctor);
        return doctor;
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
        Query query = buildProfileQuery(profile);
        return mongoTemplate.find(query, Doctor.class);
    }

    @Override
    public boolean doctorExistsByUsername(String username) {
        return mongoTemplate.exists(
                Query.query(Criteria.where("username").is(username)),
                Doctor.class
        );
    }

    @Override
    public boolean doctorExistsByEmail(String email) {
        return mongoTemplate.exists(
                Query.query(
                        new Criteria().andOperator(
                                Criteria.where("profile").exists(true),
                                Criteria.where("profile.email").is(email)
                        )
                ),
                Doctor.class
        );
    }

    @Override
    public Doctor findDoctorByUsername(String username) {
        Query query = Query.query(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query, Doctor.class);
    }

    public static Query buildProfileQuery(Profile profile) {
        Query query = new Query();
        if (profile == null) {
            return query;
        }

        List<Criteria> criteria = new ArrayList<>();

        Optional.ofNullable(profile.getFirstname())
                .ifPresent(firstname -> criteria.add(Criteria.where("profile.firstname").is(firstname)));
        Optional.ofNullable(profile.getLastname())
                .ifPresent(lastname -> criteria.add(Criteria.where("profile.lastname").is(lastname)));
        Optional.ofNullable(profile.getGender())
                .ifPresent(gender -> criteria.add(Criteria.where("profile.gender").is(gender)));
        Optional.ofNullable(profile.getBodyType())
                .ifPresent(bodyType -> criteria.add(Criteria.where("profile.bodyType").is(bodyType)));
        Optional.ofNullable(profile.getHeight())
                .ifPresent(height -> criteria.add(Criteria.where("profile.height").is(height)));
        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }

        return query;
    }
}
