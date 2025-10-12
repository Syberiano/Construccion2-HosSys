package APP.application.usescases;

import APP.domain.model.DiagnosticTest;
import APP.domain.ports.UpdateDiagnosticTestInventoryPort;
import APP.domain.services.UpdateDiagnosticTestInventory;

/**
 * Caso de uso para actualizar el inventario de pruebas diagnósticas.
 */
public class UpdateDiagnosticTestInventoryUseCase {
    
    private final UpdateDiagnosticTestInventory updateInventory;
    
    public UpdateDiagnosticTestInventoryUseCase(UpdateDiagnosticTestInventoryPort updatePort) {
        this.updateInventory = new UpdateDiagnosticTestInventory(updatePort);
    }
    
    /**
     * Actualiza el inventario de una prueba diagnóstica específica.
     *
     * @param testId   El ID de la prueba diagnóstica a actualizar.
     * @param quantity La cantidad a agregar o restar del inventario.
     * @return La prueba diagnóstica actualizada.
     * @throws Exception Si ocurre un error durante la actualización.
     */
    public DiagnosticTest execute(String testId, int quantity) throws Exception {
        return updateInventory.updateStock(testId, quantity);
    }
}
