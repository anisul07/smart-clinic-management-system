package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private final List<Doctor> doctors = new ArrayList<>();

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public Doctor getDoctorById(Long id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() != null && doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    public Doctor addDoctor(Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }
}
