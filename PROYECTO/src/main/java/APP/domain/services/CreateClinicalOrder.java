package APP.domain.services;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.model.enums.Role;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;

public class CreateClinicalOrder {
    private final UserPort userPort;
    private final PatientPort patientPort;
    private final ClinicalOrderPort clinicalOrderPort;
    
    public CreateClinicalOrder(UserPort userPort, PatientPort patientPort, ClinicalOrderPort clinicalOrderPort) {
        this.userPort = userPort;
        this.patientPort = patientPort;
        this.clinicalOrderPort = clinicalOrderPort;
    }
    
    public void create(ClinicalOrder clinicalOrder) throws Exception {
        User doctor = userPort.findByDocument(clinicalOrder.getDoctor().getDocument());
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("Las órdenes solo pueden ser creadas por los doctores");
        }
        Patient patient = patientPort.findByDocument(clinicalOrder.getPatient().getDocument());
        if (patient == null) {
            throw new Exception("Las órdenes solo se aplican a pacientes registrados");
        }
        clinicalOrder.setPatient(patient);
        clinicalOrder.setDoctor(doctor);
        clinicalOrderPort.save(clinicalOrder);
    }
}
