package org.groupnine.services;

import org.groupnine.dto.BuilderDto;

public interface CreateAccount {
    BuilderDto patientCreateAccount(String username, String password, String email, String userType);
    BuilderDto doctorCreateAccount(String username, String password, String email, String userType);

}
