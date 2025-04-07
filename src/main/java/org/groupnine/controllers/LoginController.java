package org.groupnine.controllers;

import org.groupnine.dto.LoginRequest;
import org.groupnine.services.LoginServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class LoginController {
    private final LoginServices loginServices;

    public LoginController(LoginServices loginServices) {
        this.loginServices = loginServices;
    }
    @PostMapping("/doctor/login")
    public ResponseEntity<String> doctorLogin(@RequestBody LoginRequest request) {
        boolean isValid = loginServices.doctorLogin(request.getUsername(), request.getPassword());
        if (isValid) {
            return ResponseEntity.ok("You have been logged in!");
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
    @PostMapping("/patient/login")
    public ResponseEntity<String> patientLogin(@RequestBody LoginRequest request) {
        boolean isValid = loginServices.patientLogin(request.getUsername(), request.getPassword());
        if (isValid) {
            return ResponseEntity.ok("You have been logged in!");
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
