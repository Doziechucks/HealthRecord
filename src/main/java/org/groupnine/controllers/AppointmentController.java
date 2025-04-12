package org.groupnine.controllers;

import org.groupnine.data.model.Appointment;
import org.groupnine.dto.AppointmentDetailsDto;
import org.groupnine.dto.AppointmentRequest;
import org.groupnine.services.AppointmentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentRequest request) {
        try {
            LocalDate appointmentDate = LocalDate.parse(request.getAppointmentDate());

            String appointmentId = appointmentService.bookAppointment(
                    request.getPatientId(),
                    request.getDoctorId(),
                    request.getDate(),
                    request.getAppointmentPurpose()
            );
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Appointment booked successfully. ID: " + appointmentId);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<String> cancelAppointment(@PathVariable String appointmentId) {
        try {
            String result = appointmentService.cancelAppointment(appointmentId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<String>> getUserAppointments(@PathVariable String userId) {
        try {
            String rawAppointments = appointmentService.seeUserAppointments(userId);
            List<String> appointmentIds = List.of(rawAppointments.split("\n"));
            return ResponseEntity.ok(appointmentIds);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(List.of(e.getMessage()));
        }
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDetailsDto> getAppointmentDetails(
            @PathVariable String appointmentId) {
        try {
            Appointment appointment = appointmentService.seeAppointmentDetails(appointmentId);
            return ResponseEntity.ok(mapToDto(appointment));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private @NotNull AppointmentDetailsDto mapToDto(Appointment appointment) {
        return new AppointmentDetailsDto(
                appointment.getAppointmentId(),
                appointment.getDate(),
                appointment.getPatientId(),
                appointment.getDoctorId(),
                appointment.getAppointmentPurpose()
        );
    }

}
