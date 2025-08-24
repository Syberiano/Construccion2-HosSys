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
            throw new Exception("Ya hay un paciente registrado con este documento.");
        }

        if (patientPort.findByHealthInsurance(patient) != null) {
            throw new Exception("Este paciente ya está registrado en el mismo seguro médico.");
        }

        patientPort.save(patient);
    }
}
