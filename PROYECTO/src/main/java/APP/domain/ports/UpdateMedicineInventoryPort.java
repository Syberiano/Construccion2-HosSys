package APP.domain.ports;

import APP.domain.model.Medicine;

public interface UpdateMedicineInventoryPort {
    
    Medicine updateStock(String medicineId, int quantity) throws Exception;
    
    Medicine updateMedicine(Medicine medicine) throws Exception;
}
