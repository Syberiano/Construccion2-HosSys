package APP.domain.validators;

import APP.domain.model.Person;
import APP.domain.model.emuns.Role;

import java.util.Date;

public class PersonValidator extends SimpleValidator {
    
    public static void validate(Person person) {
        validateNotNull(person, "La persona no puede ser nula");
        validateId(person.getId());
        validateDocument(person.getDocument());
        validateName(person.getName());
        validatePhoneNumber(person.getPhoneNumber());
        validateBirthDate(person.getBirthDate());
        validateAddress(person.getAddress());
        validateGender(person.getGender());
        validateRole(person.getRole());
    }
    
    protected static void validateId(String id) {
        validateNotEmpty(id, "El ID es requerido");
        if (!id.matches("[A-Za-z0-9-]+")) {
            throw new IllegalArgumentException("El ID solo puede contener letras, números y guiones");
        }
    }
    
    protected static void validateDocument(String document) {
        validateNotEmpty(document, "El documento es requerido");
        if (!document.matches("\\d{8,15}")) {
            throw new IllegalArgumentException("El documento debe contener entre 8 y 15 dígitos");
        }
    }
    
    protected static void validateName(String name) {
        validateNotEmpty(name, "El nombre es requerido");
        if (name.length() > 100) {
            throw new IllegalArgumentException("El nombre no puede tener más de 100 caracteres");
        }
        if (!name.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios");
        }
    }
    
    protected static void validatePhoneNumber(String phoneNumber) {
        validateNotEmpty(phoneNumber, "El número de teléfono es requerido");
        if (!phoneNumber.matches("\\+?[0-9]{10,15}")) {
            throw new IllegalArgumentException("El número de teléfono debe tener entre 10 y 15 dígitos");
        }
    }
    
    protected static void validateBirthDate(Date birthDate) {
        validateNotNull(birthDate, "La fecha de nacimiento es requerida");
        Date now = new Date();
        if (birthDate.after(now)) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura");
        }
        long ageInMillis = now.getTime() - birthDate.getTime();
        long years = ageInMillis / (1000L * 60 * 60 * 24 * 365);
        if (years < 18) {
            throw new IllegalArgumentException("La persona debe ser mayor de 18 años");
        }
    }
    
    protected static void validateAddress(String address) {
        validateNotEmpty(address, "La dirección es requerida");
        if (address.length() > 200) {
            throw new IllegalArgumentException("La dirección no puede tener más de 200 caracteres");
        }
    }
    
    protected static void validateGender(String gender) {
        validateNotEmpty(gender, "El género es requerido");
        if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F") && !gender.equalsIgnoreCase("O")) {
            throw new IllegalArgumentException("El género debe ser M (Masculino), F (Femenino) u O (Otro)");
        }
    }
    
    protected static void validateRole(Role role) {
        validateNotNull(role, "El rol es requerido");
        try {
            Role.valueOf(role.name());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Rol no válido: " + role);
        }
    }
}
