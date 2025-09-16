package APP.application.usescases;

import APP.domain.model.DiagnosticTest;
import APP.domain.ports.UpdateDiagnosticTestInventoryPort;
import APP.domain.validators.DiagnosticTestValidator;

public class UpdateDiagnosticTestInventoryUseCase {
    
    private final UpdateDiagnosticTestInventoryPort updateDiagnosticTestInventoryPort;
    
    public UpdateDiagnosticTestInventoryUseCase(UpdateDiagnosticTestInventoryPort updateDiagnosticTestInventoryPort) {
        this.updateDiagnosticTestInventoryPort = updateDiagnosticTestInventoryPort;
    }
    
    public DiagnosticTest updateTestStock(String testId, int quantity) {
        DiagnosticTestValidator.validateStockOperation(quantity);
        return updateDiagnosticTestInventoryPort.updateStock(testId, quantity);
    }
    
    public DiagnosticTest updateTest(DiagnosticTest test) {
        DiagnosticTestValidator.validate(test);
        return updateDiagnosticTestInventoryPort.updateTest(test);
    }
}
