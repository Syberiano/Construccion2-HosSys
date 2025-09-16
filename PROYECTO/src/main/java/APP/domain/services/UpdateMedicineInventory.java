package APP.domain.services;

import APP.domain.model.Medicine;
import APP.domain.ports.UpdateMedicineInventoryPort;
import APP.domain.validators.MedicineValidator;

public class UpdateMedicineInventory {

    private final UpdateMedicineInventoryPort updatePort;

    public UpdateMedicineInventory(UpdateMedicineInventoryPort updatePort) {
        this.updatePort = updatePort;
    }

    public Medicine updateStock(String medicineId, int quantity) {
        try {
            MedicineValidator.validateStockOperation(quantity);
            
            Medicine updatedMedicine = updatePort.updateStock(medicineId, quantity);
            
            if (updatedMedicine == null) {
                throw new RuntimeException("No se pudo actualizar el inventario del medicamento");
            }
            
            return updatedMedicine;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error al actualizar inventario: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el inventario del medicamento", e);
        }
    }
}
