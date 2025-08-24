package APP.domain.services;

import APP.domain.model.Patient;


public class RegisterPatient {

    public Patient registerPatient(String id, String name, int age, String healthInsuranceId) {
        Patient patient = new Patient();
        patient.setId(id);
        patient.setName(name);
        patient.setAge(age);
        patient.setHealthInsuranceId(healthInsuranceId);
        return patient;
    }
}
