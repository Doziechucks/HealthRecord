package org.groupnine.controllers;

import org.groupnine.dto.MedicalHistoryRequest;
import org.groupnine.services.MedicalHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class MedicalHistoryControllers {
    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryControllers(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @RequestMapping("/{patientId}/medical-history")
    public ResponseEntity<Void> addToMedicalRecord(@PathVariable String userId, @RequestBody MedicalHistoryRequest request) {
        medicalHistoryService.addToMedicalHistory(userId, request.getMedicalHistory());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/patient/{patientId}/medical-history/formatted")
    public String getFormattedMedicalHistory(
            @PathVariable String patientId) {
        return medicalHistoryService.getPatientMedicalHistory(patientId);
    }

}
