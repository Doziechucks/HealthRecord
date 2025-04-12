package org.groupnine.controllers;

import org.groupnine.data.model.*;
import org.groupnine.dto.FinderDto;
import org.groupnine.services.FindersServices;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/find")
public class FinderController {
    private final FindersServices findersServices;

    public FinderController(FindersServices findersServices) {
        this.findersServices = findersServices;
    }

    // Patient Endpoints
    @GetMapping("/patients/by-userid/{userId}")
    public ResponseEntity<String> getPatientUsernameByUserId(@PathVariable String userId) {
        String username = findersServices.findPatientByUserId(userId);
        return username != null
                ? ResponseEntity.ok(username)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/patients/by-profile")
    public ResponseEntity<List<String>>  findPatientsByProfile(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) Height height,
            @RequestParam(required = false) BodyType bodyType,
            @RequestParam(required = false) Gender gender,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth) {

        List<String> userIds = findersServices.findPatientByProfile(firstname, lastname, height, bodyType, gender, dateOfBirth);
        return !userIds.isEmpty()
                ? ResponseEntity.ok(userIds)
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/patients/by-username/{username}")
    public ResponseEntity<String> getPatientUserIdByUsername(@PathVariable String username) {
        String userId = findersServices.findPatientByUsername(username);
        return userId != null
                ? ResponseEntity.ok(userId)
                : ResponseEntity.notFound().build();
    }

    // Doctor Endpoints
    @GetMapping("/doctors/by-userid/{userId}")
    public ResponseEntity<String> getDoctorUsernameByUserId(@PathVariable String userId) {
        String username = findersServices.findDoctorByUserId(userId);
        return username != null
                ? ResponseEntity.ok(username)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/doctors/by-profile")
    public ResponseEntity<List<String>> findDoctorsByProfile(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) Height height,
            @RequestParam(required = false) BodyType bodyType,
            @RequestParam(required = false) Gender gender,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth) {

        List<String> userIds = findersServices.findDoctorByProfile(firstname, lastname, height, bodyType, gender, dateOfBirth);

        return !userIds.isEmpty()
                ? ResponseEntity.ok(userIds)
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/doctors/by-username/{username}")
    public ResponseEntity<String> getDoctorUserIdByUsername(@PathVariable String username) {
        String userId = findersServices.findDoctorByUsername(username);
        return userId != null
                ? ResponseEntity.ok(userId)
                : ResponseEntity.notFound().build();
    }
}
