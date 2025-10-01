package APP.domain.validators;

import APP.domain.model.Patient;
import APP.domain.model.Person;
import APP.domain.model.emuns.Role;

public class PatientValidator extends PersonValidator {
    
    public void validate(Patient patient) {
        validate((Person) patient);
        
        validateEmergencyContact(patient.getEmergencyContact());
        validateHealthInsurance(patient.getHealthInsurance());
    }
    
    private void validateEmergencyContact(APP.domain.model.EmergencyContact emergencyContact) {
        if (emergencyContact != null) {
            EmergencyContactValidator.validate(emergencyContact);
        }
    }
    
    private void validateHealthInsurance(APP.domain.model.HealthInsurance healthInsurance) {
        if (healthInsurance != null) {
            HealthInsuranceValidator.validate(healthInsurance);
        }
    }
    
    /*@Override
    protected void validateRole(APP.domain.model.emuns.Role role) {
        super.validateRole(role);
        if (role != Role.PATIENT) {
            throw new IllegalArgumentException("El rol para un paciente debe ser PACIENTE");
        }
    }*/
}
