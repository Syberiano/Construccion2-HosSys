package APP.domain.ports;

import APP.domain.model.DiagnosticTest;

public interface UpdateDiagnosticTestInventoryPort {
    
    DiagnosticTest updateStock(String testId, int quantity) throws Exception;
    
    DiagnosticTest updateDiagnosticTest(DiagnosticTest diagnosticTest) throws Exception;
}
