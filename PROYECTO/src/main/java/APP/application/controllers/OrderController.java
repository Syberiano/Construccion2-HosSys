package APP.application.controllers;

import APP.infrastructure.persistance.entities.*;
import APP.infrastructure.persistance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private PatientRepository pacienteRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private MedicamentoRepository medicamentoRepo;

    @Autowired
    private OrdenMedicaRepository ordenRepo;

    @Autowired
    private InvoiceRepository invoiceRepo;

    // DTOs
    public static class CreateOrderRequest {
        public String doctorDocument;
        public String patientDocument;
        public String diagnostico;
        public List<Long> medicamentoIds;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest req) {
        if (req == null || req.doctorDocument == null || req.doctorDocument.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "doctorDocument es requerido"));
        }
        if (req.patientDocument == null || req.patientDocument.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "patientDocument es requerido"));
        }

        DoctorEntity doctor = doctorRepo.findByDocument(req.doctorDocument).orElse(null);
        if (doctor == null) {
            // crear doctor rápido de prueba
            doctor = new DoctorEntity();
            doctor.setDocument(req.doctorDocument);
            doctor.setName("Doctor " + req.doctorDocument);
            doctor.setRole(APP.domain.model.enums.Role.DOCTOR);
            String idDoc = UUID.randomUUID().toString();
            doctor.setId(idDoc);
            doctorRepo.save(doctor);
        }

        PatientEntity paciente = pacienteRepo.findByDocument(req.patientDocument).orElse(null);
        if (paciente == null) {
            // crear paciente de prueba
            paciente = new PatientEntity();
            paciente.setDocument(req.patientDocument);
            paciente.setName("Paciente " + req.patientDocument);
            paciente.setRole(APP.domain.model.enums.Role.PATIENT);
            pacienteRepo.save(paciente);
        }

        OrdenMedicaEntity orden = new OrdenMedicaEntity();
        orden.setDoctor(doctor);
        orden.setPaciente(paciente);
        orden.setDiagnostico(req.diagnostico);
        orden.setEstado("ACTIVA");

        List<MedicamentoEntity> meds = new ArrayList<>();
        if (req.medicamentoIds != null) {
            for (Long id : req.medicamentoIds) {
                medicamentoRepo.findById(id).ifPresent(meds::add);
            }
        }
        orden.setMedicamentosPrescritos(meds);

        ordenRepo.save(orden);

        // generar invoice
        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setPaciente(paciente);
        invoice.setOrdenMedica(orden);
        invoice.setFecha(new Date());
        BigDecimal total = BigDecimal.ZERO;
        List<MedicamentoEntity> invoiceMeds = new ArrayList<>();
        for (MedicamentoEntity m : meds) {
            if (m.getPrecioUnitario() != null) {
                total = total.add(BigDecimal.valueOf(m.getPrecioUnitario()));
                invoiceMeds.add(m);
            }
        }
        invoice.setMedicamentos(invoiceMeds);
        invoice.setTotal(total);
        invoice.setStatus("GENERADA");
        invoiceRepo.save(invoice);

        return ResponseEntity.status(201).body(Map.of("orderId", orden.getId(), "invoiceId", invoice.getId()));
    }
}
