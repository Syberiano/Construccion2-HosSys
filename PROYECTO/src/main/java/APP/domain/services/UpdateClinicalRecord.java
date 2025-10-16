
package APP.domain.services;

import APP.domain.model.ClinicalRecord;
public class UpdateClinicalRecord {
    
    public void update(ClinicalRecord record) throws Exception {
    if (record == null || record.getId() <= 0) {
        throw new Exception("Datos de historia clinica invalidos");
    }
    System.out.println("La historia clinica " + record.getId() + " fue actualizada correctamente.");
}
}
