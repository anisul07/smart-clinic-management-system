package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.repo.PrescriptionRepository;
import com.project.back_end.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionRepository prescriptionRepository;
    private final TokenService tokenService;

    public PrescriptionController(PrescriptionRepository prescriptionRepository,
                                   TokenService tokenService) {
        this.prescriptionRepository = prescriptionRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/{token}")
    public ResponseEntity<?> addPrescription(
            @PathVariable String token,
            @Valid @RequestBody Prescription prescription) {

        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid token"));
        }

        Prescription saved = prescriptionRepository.save(prescription);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Map.of(
                        "message", "Prescription saved successfully",
                        "id", saved.getId()
                )
        );
    }
}
