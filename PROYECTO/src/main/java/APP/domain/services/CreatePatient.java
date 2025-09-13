
package APP.domain.services;

import APP.domain.model.Patient;

public class CreatePatient {
    
     public void create(Patient patient) throws Exception {
        if (patient == null || patient.getId() == null || patient.getName() == null) {
            throw new Exception("Datos de paciente inválidos");
        }
        System.out.println("El paciente " + patient.getName() + " fue registrado correctamente.");
    }
}
