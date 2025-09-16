package APP.domain.validators;

import APP.domain.model.HealthInsurance;

public class HealthInsuranceValidator extends SimpleValidator {
    
    public static void validate(HealthInsurance insurance) {
        validateNotNull(insurance, "El seguro médico no puede ser nulo");
        validateInsuranceId(insurance.getInsuranceId());
        validateProviderName(insurance.getProviderName());
        validatePolicyNumber(insurance.getPolicyNumber());
    }
    
    private static void validateInsuranceId(String insuranceId) {
        validateNotEmpty(insuranceId, "El ID del seguro es requerido");
        if (insuranceId.length() > 50) {
            throw new IllegalArgumentException("El ID del seguro no puede tener más de 50 caracteres");
        }
    }
    
    private static void validateProviderName(String providerName) {
        validateNotEmpty(providerName, "El nombre del proveedor es requerido");
        if (providerName.length() > 100) {
            throw new IllegalArgumentException("El nombre del proveedor no puede tener más de 100 caracteres");
        }
    }
    
    private static void validatePolicyNumber(String policyNumber) {
        validateNotEmpty(policyNumber, "El número de póliza es requerido");
        if (policyNumber.length() > 50) {
            throw new IllegalArgumentException("El número de póliza no puede tener más de 50 caracteres");
        }
    }
}
