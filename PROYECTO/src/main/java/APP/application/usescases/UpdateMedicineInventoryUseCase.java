package APP.application.usescases;

import APP.domain.model.Medicine;
import APP.domain.ports.UpdateMedicineInventoryPort;
import APP.domain.services.UpdateMedicineInventory;

public class UpdateMedicineInventoryUseCase {
    
    private final UpdateMedicineInventory updateInventory;
    
    public UpdateMedicineInventoryUseCase(UpdateMedicineInventoryPort updatePort) {
        this.updateInventory = new UpdateMedicineInventory(updatePort);
    }
    
    public Medicine execute(String medicineId, int quantity) {
        return updateInventory.updateStock(medicineId, quantity);
    }
}
