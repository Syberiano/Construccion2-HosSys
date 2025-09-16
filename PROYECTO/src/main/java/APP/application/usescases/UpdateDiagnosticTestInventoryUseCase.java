package APP.application.usescases;

import APP.domain.model.DiagnosticTest;
import APP.domain.ports.UpdateDiagnosticTestInventoryPort;
import APP.domain.services.UpdateDiagnosticTestInventory;

public class UpdateDiagnosticTestInventoryUseCase {
    
    private final UpdateDiagnosticTestInventory updateInventory;
    
    public UpdateDiagnosticTestInventoryUseCase(UpdateDiagnosticTestInventoryPort updatePort) {
        this.updateInventory = new UpdateDiagnosticTestInventory(updatePort);
    }
    
    public DiagnosticTest execute(String testId, int quantity) {
        return updateInventory.updateStock(testId, quantity);
    }
}
