package org.groupnine.dto;

import lombok.Getter;

import lombok.Setter;

import java.time.LocalDate;


public record AppointmentDetailsDto(String appointmentId,
                                    LocalDate date,
                                    String patientId,
                                    String doctorId,
                                    String purpose
)

{
}
