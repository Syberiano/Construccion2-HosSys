package APP.domain.model;

import java.util.Date;

import APP.domain.model.enums.Role;

public class Patient extends Person{

    private EmergencyContact emergencyContact;
    private HealthInsurance healthInsurance;

    public Patient(String id, String document, String name, String phoneNumber, Date birthDate, String address, String gender, Role role) {
        super(id, document, name, phoneNumber, birthDate, address, gender, role);
    }

    public Patient(String id, String document, String name, String phoneNumber, Date birthDate, String address, String gender, Role role, EmergencyContact emergencyContact, HealthInsurance healthInsurance) {
        super(id, document, name, phoneNumber, birthDate, address, gender, role);
        if (emergencyContact == null) throw new IllegalArgumentException("El contacto de emergencia no puede ser nulo");
        if (healthInsurance == null) throw new IllegalArgumentException("El seguro de salud no puede ser nulo");
        this.emergencyContact = emergencyContact;
        this.healthInsurance = healthInsurance;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }
}
