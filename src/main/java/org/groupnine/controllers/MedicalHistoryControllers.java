package org.groupnine.controllers;

import org.groupnine.services.MedicalHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class MedicalHistoryControllers {
    private final MedicalHistoryService medicalHistoryService;

    public MedicalHistoryControllers(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    @RequestMapping("/")
}
