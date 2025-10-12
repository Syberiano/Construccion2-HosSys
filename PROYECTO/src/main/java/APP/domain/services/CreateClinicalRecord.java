package APP.domain.services;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.ClinicalRecordPort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;

public class CreateClinicalRecord {
    
    private final UserPort userPort;
    private final PatientPort patientPort;
    private final ClinicalOrderPort clinicalOrderPort;
    private final ClinicalRecordPort clinicalRecordPort;
    
    public CreateClinicalRecord(UserPort userPort, PatientPort patientPort, ClinicalOrderPort clinicalOrderPort, ClinicalRecordPort clinicalRecordPort) {
        this.userPort = userPort;
        this.patientPort = patientPort;
        this.clinicalOrderPort = clinicalOrderPort;
        this.clinicalRecordPort = clinicalRecordPort;
    }
    
    public void create(ClinicalRecord clinicalRecord) throws Exception {
        Patient patient = patientPort.findByDocument(clinicalRecord.getPatient().getDocument());
        if (patient == null) {
            throw new Exception("La historia clínica debe tener un paciente válido");
        }
        User doctor = userPort.findByDocument(clinicalRecord.getDoctor().getDocument());
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("La historia clínica debe ser creada por un doctor válido");
        }
        ClinicalOrder clinicalOrder = clinicalOrderPort.findById(clinicalRecord.getClinicalOrder().getId());
        if (clinicalOrder == null) {
            throw new Exception("La historia clínica debe tener una orden válida");
        }
        
        clinicalRecord.setPatient(patient);
        clinicalRecord.setDoctor(doctor);
        clinicalRecord.setClinicalOrder(clinicalOrder);
        clinicalRecordPort.save(clinicalRecord);
    }
}
