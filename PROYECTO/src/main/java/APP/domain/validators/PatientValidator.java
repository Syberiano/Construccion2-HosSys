package APP.domain.validators;

import APP.domain.model.Patient;

public class PatientValidator extends PersonValidator {
    
    public static void validate(Patient patient) {
        validate((Person) patient);
        
        validateEmergencyContact(patient.getEmergencyContact());
        validateHealthInsurance(patient.getHealthInsurance());
    }
    
    private static void validateEmergencyContact(APP.domain.model.EmergencyContact emergencyContact) {
        if (emergencyContact != null) {
            EmergencyContactValidator.validate(emergencyContact);
        }
    }
    
    private static void validateHealthInsurance(APP.domain.model.HealthInsurance healthInsurance) {
        if (healthInsurance != null) {
            HealthInsuranceValidator.validate(healthInsurance);
        }
    }
    
    @Override
    protected static void validateRole(APP.domain.model.emuns.Role role) {
        super.validateRole(role);
        if (role != APP.domain.model.emuns.Role.PACIENTE) {
            throw new IllegalArgumentException("El rol para un paciente debe ser PACIENTE");
        }
    }
}
