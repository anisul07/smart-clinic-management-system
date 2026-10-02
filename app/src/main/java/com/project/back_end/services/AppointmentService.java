package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private final List<Appointment> appointments = new ArrayList<>();

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment addAppointment(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        List<Appointment> result = new ArrayList<>();

        for (Appointment appointment : appointments) {
            if (appointment.getPatientId().equals(patientId)) {
                result.add(appointment);
            }
        }

        return result;
    }

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        List<Appointment> result = new ArrayList<>();

        for (Appointment appointment : appointments) {
            if (appointment.getDoctorId().equals(doctorId)) {
                result.add(appointment);
            }
        }

        return result;
    }
}
