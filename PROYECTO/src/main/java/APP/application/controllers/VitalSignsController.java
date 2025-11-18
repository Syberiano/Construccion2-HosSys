package APP.application.controllers;

import APP.domain.services.RegisterVitalSigns;
import APP.infrastructure.persistance.entities.PatientEntity;
import APP.infrastructure.persistance.entities.VitalSignEntity;
import APP.infrastructure.persistance.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VitalSignsController {

    @Autowired
    private RegisterVitalSigns vitalSignsService;

    @Autowired
    private PatientRepository patientRepo;

    // DTO
    public static class VitalSignsRequest {
        public String bloodPressure;
        public int heartRate;
        public double temperature;
        public double weight;
    }

    @PostMapping("/patients/{document}/vitals")
    public ResponseEntity<?> registerVitalSigns(@PathVariable("document") String document,
                                                @RequestBody VitalSignsRequest req) {
        if (document == null || document.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Documento es requerido"));
        }
        PatientEntity paciente = patientRepo.findAll().stream()
                .filter(p -> document.equals(p.getDocument()))
                .findFirst().orElse(null);
        if (paciente == null) {
            return ResponseEntity.status(404).body(Map.of("error", "Paciente no encontrado"));
        }
        try {
            VitalSignEntity saved = vitalSignsService.register(paciente.getId(), req.bloodPressure, req.heartRate, req.temperature, req.weight);
            return ResponseEntity.status(201).body(Map.of("message", "Signos vitales registrados", "vitalId", saved.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/patients/{document}/vitals")
    public ResponseEntity<?> getVitalSigns(@PathVariable("document") String document) {
        if (document == null || document.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Documento es requerido"));
        }
        PatientEntity paciente = patientRepo.findAll().stream()
                .filter(p -> document.equals(p.getDocument()))
                .findFirst().orElse(null);
        if (paciente == null) {
            return ResponseEntity.status(404).body(Map.of("error", "Paciente no encontrado"));
        }
        try {
            List<VitalSignEntity> signos = vitalSignsService.getAll(paciente.getId());
            return ResponseEntity.ok(Map.of("patientId", paciente.getId(), "document", paciente.getDocument(), "vitals", signos));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }
}
