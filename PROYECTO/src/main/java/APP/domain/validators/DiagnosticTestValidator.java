package APP.domain.validators;

import APP.domain.model.DiagnosticTest;

public class DiagnosticTestValidator extends SimpleValidator {
    
    public static void validate(DiagnosticTest test) {
        validateNotNull(test, "La prueba diagnóstica no puede ser nula");
        validateNotEmpty(test.getId(), "El ID de la prueba diagnóstica es requerido");
        validateNotEmpty(test.getName(), "El nombre de la prueba diagnóstica es requerido");
        validatePositive(test.getCost(), "El costo de la prueba no puede ser negativo");
        validateNotNull(test.getSpecialty(), "La especialidad de la prueba es requerida");
        
        if (test.getCost() > 1000000) {
            throw new IllegalArgumentException("El costo de la prueba no puede ser mayor a 1,000,000");
        }
    }
    
    public static void validateStockOperation(int quantity) {
        validateNotZero(quantity, "La cantidad no puede ser cero");
        if (quantity < -1000 || quantity > 1000) {
            throw new IllegalArgumentException("La cantidad debe estar entre -1000 y 1000");
        }
    }
}
