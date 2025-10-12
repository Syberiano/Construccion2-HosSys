package APP.domain.ports;

import APP.domain.model.Patient;
import java.util.List;

public interface PatientPort {

    Patient save(Patient patient) throws Exception;

    boolean existsById(String id) throws Exception;

    boolean existsByDocument(String document) throws Exception;

    Patient findById(String id) throws Exception;

    Patient findByDocument(String document) throws Exception;

    boolean deleteById(String id) throws Exception;

    List<Patient> findAll() throws Exception;

    List<Patient> findByName(String name) throws Exception;
}
