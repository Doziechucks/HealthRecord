package org.groupnine.controllers;

import org.groupnine.dto.UpdateProfileDto;
import org.groupnine.services.UpdateProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class UpdateProfileController {
    private final UpdateProfileService updateProfileService;

    public UpdateProfileController(UpdateProfileService updateProfileService) {
        this.updateProfileService = updateProfileService;
    }

    @PutMapping("/doctor/{userId}")
    public ResponseEntity<Void> updateDoctorProfile(@PathVariable String userId, @Validated @RequestBody UpdateProfileDto dto) {
        updateProfileService.updateDoctorProfile(userId, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/patient/{userId}")
    public ResponseEntity<Void> updatePatientProfile(@PathVariable String userId, @Validated @RequestBody UpdateProfileDto dto) {
        updateProfileService.updatePatientProfile(userId, dto);
        return ResponseEntity.ok().build();
    }
}
