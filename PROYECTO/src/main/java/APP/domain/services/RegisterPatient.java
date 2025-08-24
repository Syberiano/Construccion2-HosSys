package app.domain.services;

import APP.domain.model.Patient;
import APP.domain.ports.PatientPort;

public class RegisterPatient {

    private final PatientPort patientPort;

    public RegisterPatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void register(Patient patient) throws Exception {
        if (patientPort.findByDocument(patient) != null) {
            throw new Exception("There is already a patient registered with this document.");
        }

        if (patientPort.findByHealthInsurance(patient) != null) {
            throw new Exception("This patient is already registered with the same health insurance.");
        }

        patientPort.save(patient);
    }
}
