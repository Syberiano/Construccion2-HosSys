package APP.domain.ports;

import APP.domain.model.Patient;

public interface PatientPort {

    Patient findByDocument(Patient patient);

    Patient findByHealthInsurance(Patient patient);

    void save(Patient patient);
}
