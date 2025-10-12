package APP.domain.ports;

import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import java.util.List;

public interface ClinicalRecordPort {
    
    ClinicalRecord findById(Long id) throws Exception;

    List<ClinicalRecord> findByPatient(Patient patient) throws Exception;

    void save(ClinicalRecord clinicalRecord) throws Exception;
}
