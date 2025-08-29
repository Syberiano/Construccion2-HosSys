
package APP.domain.ports;

import APP.domain.model.ClinicalRecord;
public interface ClinicalRecordPort {
    
    ClinicalRecord findById (String id);
    
   

    public void save(ClinicalRecord clinicalRecord);
}
