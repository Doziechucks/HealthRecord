package org.groupnine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MedicalHistoryRequest {
    private String userId;
    private String medicalHistory;

    public MedicalHistoryRequest(String userId, String medicalHistory) {
        this.userId = userId;
        this.medicalHistory = medicalHistory;
    }
}

