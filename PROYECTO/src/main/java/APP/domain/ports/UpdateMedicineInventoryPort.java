package APP.domain.ports;

import APP.domain.model.Medicine;

public interface UpdateMedicineInventoryPort {
    
    Medicine updateStock(String medicineId, int quantity);
    
    Medicine updateMedicine(Medicine medicine);
}
