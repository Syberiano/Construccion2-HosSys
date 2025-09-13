
package APP.domain.services;

import APP.domain.model.ClinicalRecord;
import java.util.ArrayList;
import java.util.List;
public class SearchClinicalRecord {
    
     private List<ClinicalRecord> records = new ArrayList<>();

    public List<ClinicalRecord> findByPatient(String patientId) throws Exception {
        List<ClinicalRecord> result = new ArrayList<>();
        for (ClinicalRecord r : records) {
            if (r.getPatient().getId().equals(patientId)) {
                result.add(r);
        }
        }
        if (result.isEmpty()) {
            throw new Exception("No se encontraron historias clínicas para el paciente: " + patientId);
        }
        return result;
    }
}
