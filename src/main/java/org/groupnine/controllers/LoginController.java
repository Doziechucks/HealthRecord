package org.groupnine.controllers;

import org.groupnine.dto.BuilderDto;
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
    public ResponseEntity<?> doctorLogin(@RequestBody LoginRequest request) {
        try {
            BuilderDto doctorDto = loginServices.doctorLogin(
                    request.getUsername(),
                    request.getPassword()
            );
            return ResponseEntity.ok(doctorDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }
    @PostMapping("/patient/login")
    public ResponseEntity<?> patientLogin(@RequestBody LoginRequest request) {
        try {
            BuilderDto patientDto = loginServices.patientLogin(
                    request.getUsername(),
                    request.getPassword()
            );
            return ResponseEntity.ok(patientDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }
}
