package org.groupnine.controllers;

import org.groupnine.dto.RegisterationRequest;
import org.groupnine.services.CreateAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class RegistrationController {
    private final CreateAccount createAccountService;

    public RegistrationController(CreateAccount createAccountService) {
        this.createAccountService = createAccountService;
    }

    @PostMapping("/patient/register")
    public ResponseEntity<String> registerPatient(@RequestBody RegisterationRequest request) {
        try {
            String userId = createAccountService.patientCreateAccount(
                    request.getUsername(),
                    request.getPassword());
            return ResponseEntity.ok("Patient created with ID: " + userId);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
    @PostMapping("/doctor/register")
    public ResponseEntity<String> registerDoctor(@RequestBody RegisterationRequest request) {
        try {
            String userId = createAccountService.doctorCreateAccount(
                    request.getUsername(),
                    request.getPassword()
            );
            return ResponseEntity.ok("Doctor created with ID: " + userId);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
