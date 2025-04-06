package org.groupnine.services;

import java.util.List;

public interface MedicalHistoryService {
    void addToMedicalHistory(String userId, String medicalHistory);
    List<String> getMedicalHistory(String userId, String medicalHistory);
}
