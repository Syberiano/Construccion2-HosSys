package APP.domain.ports;

import APP.domain.model.DiagnosticTest;

public interface UpdateDiagnosticTestInventoryPort {
    
    DiagnosticTest updateStock(String testId, int quantity);
    
    DiagnosticTest updateDiagnosticTest(DiagnosticTest diagnosticTest);
}
