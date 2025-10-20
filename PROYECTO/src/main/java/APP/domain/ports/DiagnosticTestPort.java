package APP.domain.ports;

import APP.domain.model.DiagnosticTest;
import java.util.List;

public interface DiagnosticTestPort {

    DiagnosticTest save(DiagnosticTest diagnosticTest) throws Exception;

    DiagnosticTest findById(String id) throws Exception;

    List<DiagnosticTest> findByName(String name) throws Exception;

    List<DiagnosticTest> findAll() throws Exception;

    boolean deleteById(String id) throws Exception;
}
