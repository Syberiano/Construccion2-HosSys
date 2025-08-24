package APP.domain.ports;

import APP.domain.model.Patient;

public interface PatientPort {
    void save(Patient patient);
    Patient findById(Long id);
}
