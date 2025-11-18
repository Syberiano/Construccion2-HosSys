
package APP.application.controllers;

import APP.infrastructure.persistance.entities.*;
import APP.infrastructure.persistance.repository.*;
import APP.domain.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private PatientRepository pacienteRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    public static class CreatePatientReq {
        public String document;
        public String name;
    }

    public static class CreateDoctorReq {
        public String document;
        public String name;
    }

    @PostMapping("/patients")
    public ResponseEntity<?> createPatient(@RequestBody CreatePatientReq req) {
        if (req.document == null || req.document.isEmpty()) return ResponseEntity.badRequest().body(Map.of("error","document required"));
        if (req.name == null || req.name.isEmpty()) req.name = "Paciente " + req.document;
        if (pacienteRepo.existsByDocument(req.document)) return ResponseEntity.status(409).body(Map.of("error","Paciente ya existe"));
        PatientEntity p = new PatientEntity();
        p.setDocument(req.document);
        p.setName(req.name);
        p.setRole(Role.PATIENT);
        pacienteRepo.save(p);
        return ResponseEntity.status(201).body(Map.of("id", p.getId(), "document", p.getDocument()));
    }

    @PostMapping("/doctors")
    public ResponseEntity<?> createDoctor(@RequestBody CreateDoctorReq req) {
        if (req.document == null || req.document.isEmpty()) return ResponseEntity.badRequest().body(Map.of("error","document required"));
        if (req.name == null || req.name.isEmpty()) req.name = "Doctor " + req.document;
        if (doctorRepo.existsByDocument(req.document)) return ResponseEntity.status(409).body(Map.of("error","Doctor ya existe"));
        DoctorEntity d = new DoctorEntity();
        d.setDocument(req.document);
        d.setName(req.name);
        d.setRole(Role.DOCTOR);
        d.setId(UUID.randomUUID().toString());
        doctorRepo.save(d);
        return ResponseEntity.status(201).body(Map.of("id", d.getId(), "document", d.getDocument()));
    }
}

