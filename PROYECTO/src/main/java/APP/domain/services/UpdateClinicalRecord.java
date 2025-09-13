
package APP.domain.services;

import APP.domain.model.ClinicalRecord;
public class UpdateClinicalRecord {
    
    public void update(ClinicalRecord record) throws Exception {
    if (record == null || record.getId() <= 0) {
        throw new Exception("Datos de historia clínica inválidos");
    }
    System.out.println("La historia clínica " + record.getId() + " fue actualizada correctamente.");
}
}
