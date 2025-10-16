package APP.domain.validators;

import APP.domain.model.EmergencyContact;

public class EmergencyContactValidator extends SimpleValidator {
    
    public static void validate(EmergencyContact contact) {
        validateNotNull(contact, "El contacto de emergencia no puede ser nulo");
        validateName(contact.getName());
        validatePhoneNumber(contact.getPhoneNumber());
        validateRelationship(contact.getRelationship());
    }
    
    private static void validateName(String name) {
        validateNotEmpty(name, "El nombre del contacto de emergencia es requerido");
        if (name.length() > 100) {
            throw new IllegalArgumentException("El nombre no puede tener más de 100 caracteres");
        }
    }
    
    private static void validatePhoneNumber(String phoneNumber) {
        validateNotEmpty(phoneNumber, "El numero de telefono es requerido");
        if (!phoneNumber.matches("\\+?[0-9]{10,15}")) {
            throw new IllegalArgumentException("El numero de telefono debe tener entre 10 y 15 digitos");
        }
    }
    
    private static void validateRelationship(String relationship) {
        validateNotEmpty(relationship, "La relacion con el contacto es requerida");
        if (relationship.length() > 50) {
            throw new IllegalArgumentException("La relacion no puede tener mas de 50 caracteres");
        }
    }
}
