package org.groupnine.services;

import org.groupnine.dto.BuilderDto;

public interface LoginServices {


    BuilderDto doctorLogin(String username, String password);
    BuilderDto patientLogin(String username, String password);
}
