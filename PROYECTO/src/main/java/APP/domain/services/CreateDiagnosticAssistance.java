package APP.domain.services;

import APP.domain.model.DiagnosticTest;
import APP.domain.ports.DiagnosticTestPort;

public class CreateDiagnosticAssistance {
    
    private final DiagnosticTestPort diagnosticTestPort;

    public CreateDiagnosticAssistance(DiagnosticTestPort diagnosticTestPort) {
        this.diagnosticTestPort = diagnosticTestPort;
    }
    
    public void create(DiagnosticTest diagnosticTest) throws Exception {
        if (diagnosticTest == null) {
            throw new Exception("La ayuda diagnóstica no puede ser nula");
        }
        if (diagnosticTest.getName() == null || diagnosticTest.getName().isEmpty()) {
            throw new Exception("El nombre de la ayuda diagnóstica es obligatorio");
        }
        if (diagnosticTest.getCost() <= 0) {
            throw new Exception("El costo de la ayuda diagnóstica debe ser mayor que 0");
        }
        diagnosticTestPort.save(diagnosticTest);
        System.out.println("Ayuda diagnóstica registrada: " + diagnosticTest.getName() + " con costo de: " + diagnosticTest.getCost());
    }
}
