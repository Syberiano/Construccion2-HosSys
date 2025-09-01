package APP.domain.model;

import APP.domain.model.emuns.Role;

import java.util.Date;

public class Patient extends Person{

    private EmergencyContact emergencyContact;
    private HealthInsurance healthInsurance;

    public Patient(String id, String document, String name, String phoneNumber, Date birthDate, String address, String gender, Role role) {
        super(id, document, name, phoneNumber, birthDate, address, gender, role);
    }

    public Patient(String id, String document, String name, String phoneNumber, Date birthDate, String address, String gender, Role role, EmergencyContact emergencyContact, HealthInsurance healthInsurance) {
        super(id, document, name, phoneNumber, birthDate, address, gender, role);
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
