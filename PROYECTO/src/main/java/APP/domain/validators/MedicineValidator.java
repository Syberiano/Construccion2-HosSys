package APP.domain.validators;

import APP.domain.model.Medicine;

public class MedicineValidator extends SimpleValidator {
    
    public static void validate(Medicine medicine) {
        validateNotNull(medicine, "El medicamento no puede ser nulo");
        validateNotEmpty(medicine.getId(), "El ID del medicamento es requerido");
        validateName(medicine.getName());
        validateCost(medicine.getCost());
        
        if (medicine.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }
    
    public static void validateStockOperation(int quantity) {
        validateNotZero(quantity, "La cantidad no puede ser cero");
        if (quantity < -1000 || quantity > 1000) {
            throw new IllegalArgumentException("La cantidad debe estar entre -1000 y 1000");
        }
    }
    
    private static void validateName(String name) {
        validateNotEmpty(name, "El nombre del medicamento es requerido");
        if (name.length() > 100) {
            throw new IllegalArgumentException("El nombre no puede tener más de 100 caracteres");
        }
    }
    
    private static void validateCost(double cost) {
        validatePositive(cost, "El costo del medicamento no puede ser negativo");
        if (cost > 1000000) {
            throw new IllegalArgumentException("El costo no puede ser mayor a 1,000,000");
        }
    }
}
