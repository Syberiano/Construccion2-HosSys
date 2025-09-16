package APP.application.usescases;

import APP.domain.model.Medicine;
import APP.domain.ports.UpdateMedicineInventoryPort;
import APP.domain.validators.MedicineValidator;

public class UpdateMedicineInventoryUseCase {
    
    private final UpdateMedicineInventoryPort updateMedicineInventoryPort;
    
    public UpdateMedicineInventoryUseCase(UpdateMedicineInventoryPort updateMedicineInventoryPort) {
        this.updateMedicineInventoryPort = updateMedicineInventoryPort;
    }
    
    public Medicine updateMedicineStock(String medicineId, int quantity) {
        MedicineValidator.validateStockOperation(quantity);
        return updateMedicineInventoryPort.updateStock(medicineId, quantity);
    }
    
    public Medicine updateMedicine(Medicine medicine) {
        MedicineValidator.validate(medicine);
        return updateMedicineInventoryPort.updateMedicine(medicine);
    }
}
