package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctorsBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }

    public List<String> getAvailableTimeSlots(Long doctorId, String date) {
        try {
            return getAvailableTimeSlots(doctorId, LocalDate.parse(date));
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<String> getAvailableTimeSlots(Long doctorId, LocalDate date) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor == null || date == null) {
            return Collections.emptyList();
        }

        List<String> slots = doctor.getAvailableTimes();
        if (slots != null && !slots.isEmpty()) {
            return new ArrayList<>(slots);
        }

        if (doctor.getAvailableTime() != null && !doctor.getAvailableTime().trim().isEmpty()) {
            return List.of(doctor.getAvailableTime());
        }

        return Collections.emptyList();
    }

    public Map<String, Object> validateDoctorLogin(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email);

        if (doctor != null && doctor.getPassword() != null
                && doctor.getPassword().equals(password)) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("success", true);
            response.put("message", "Login successful");
            response.put("doctorId", doctor.getId());
            response.put("email", doctor.getEmail());
            return response;
        }

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", false);
        response.put("message", "Invalid doctor credentials");
        return response;
    }
}
