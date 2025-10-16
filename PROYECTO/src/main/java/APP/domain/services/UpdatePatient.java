
package APP.domain.services;

import APP.domain.model.Patient;
public class UpdatePatient {
    public void update(Patient patient) throws Exception {
        if (patient == null || patient.getId() == null) {
            throw new Exception("Datos de paciente invalidos");
        }
        System.out.println("El paciente " + patient.getName() + " fue actualizado correctamente.");
    }
}
