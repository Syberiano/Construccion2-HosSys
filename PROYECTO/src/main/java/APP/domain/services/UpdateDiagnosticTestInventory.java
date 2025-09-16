package APP.domain.services;

import APP.domain.model.DiagnosticTest;
import APP.domain.ports.UpdateDiagnosticTestInventoryPort;
import APP.domain.validators.DiagnosticTestValidator;

public class UpdateDiagnosticTestInventory {

    private final UpdateDiagnosticTestInventoryPort updatePort;

    public UpdateDiagnosticTestInventory(UpdateDiagnosticTestInventoryPort updatePort) {
        this.updatePort = updatePort;
    }

    public DiagnosticTest updateStock(String testId, int quantity) {
        try {
            DiagnosticTestValidator.validateStockOperation(quantity);
            
            DiagnosticTest updatedTest = updatePort.updateStock(testId, quantity);
            
            if (updatedTest == null) {
                throw new RuntimeException("No se pudo actualizar el inventario de la prueba diagnóstica");
            }
            
            return updatedTest;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error al actualizar inventario: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el inventario de la prueba diagnóstica", e);
        }
    }
}
