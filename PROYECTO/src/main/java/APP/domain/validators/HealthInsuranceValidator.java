package APP.domain.validators;

import APP.domain.model.HealthInsurance;

public class HealthInsuranceValidator extends SimpleValidator {
    
    public static void validate(HealthInsurance insurance) {
        validateNotNull(insurance, "El seguro medico no puede ser nulo");
        validateInsuranceId(insurance.getInsuranceId());
        validateProviderName(insurance.getProviderName());
        //validatePolicyNumber(insurance.getPolicyNumber());
    }
    
    private static void validateInsuranceId(String insuranceId) {
        validateNotEmpty(insuranceId, "El ID del seguro es requerido");
        if (insuranceId.length() > 50) {
            throw new IllegalArgumentException("El ID del seguro no puede tener mas de 50 caracteres");
        }
    }
    
    private static void validateProviderName(String providerName) {
        validateNotEmpty(providerName, "El nombre del proveedor es requerido");
        if (providerName.length() > 100) {
            throw new IllegalArgumentException("El nombre del proveedor no puede tener mas de 100 caracteres");
        }
    }
    
    // Método no usado actualmente, pero disponible para validación futura
    /*
    private static void validatePolicyNumber(String policyNumber) {
        validateNotEmpty(policyNumber, "El número de poliza es requerido");
        if (policyNumber.length() > 50) {
            throw new IllegalArgumentException("El número de poliza no puede tener más de 50 caracteres");
        }
    }
    */
}
