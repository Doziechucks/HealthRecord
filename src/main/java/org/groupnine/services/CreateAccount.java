package org.groupnine.services;

import org.groupnine.data.model.Doctor;
import org.groupnine.data.model.Patient;

public interface CreateAccount {
    String patientCreateAccount(String username, String password);
    String doctorCreateAccount(String username, String password);

}
