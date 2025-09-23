package APP.domain.ports;

import APP.domain.model.Patient;

public interface PatientPort {

    Patient save(Patient patient);

    boolean existsById(String id);
    

    boolean existsByDocument(String document);

    Patient findById(String id);

    Patient findByDocument(String document);

    boolean deleteById(String id);
}
