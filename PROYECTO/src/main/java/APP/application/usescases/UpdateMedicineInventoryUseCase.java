package APP.application.usescases;

import APP.domain.model.Medicine;
import APP.domain.ports.UpdateMedicineInventoryPort;
import APP.domain.services.UpdateMedicineInventory;

/**
 * Caso de uso para actualizar el inventario de medicamentos.
 */
public class UpdateMedicineInventoryUseCase {
    
    private final UpdateMedicineInventory updateInventory;
    
    public UpdateMedicineInventoryUseCase(UpdateMedicineInventoryPort updatePort) {
        this.updateInventory = new UpdateMedicineInventory(updatePort);
    }
    
    /**
     * Actualiza el stock de un medicamento específico.
     * @param medicineId ID del medicamento
     * @param quantity cantidad a agregar o restar
     * @return El medicamento actualizado
     * @throws Exception si ocurre un error en la actualización
     */
    public Medicine execute(String medicineId, int quantity) throws Exception {
        return updateInventory.updateStock(medicineId, quantity);
    }
}
