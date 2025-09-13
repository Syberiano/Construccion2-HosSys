
package APP.domain.services;

import APP.domain.model.Patient;
public class SearchPatient {
    public Patient findById(Patient patient, String id) throws Exception {
        if (patient == null || patient.getId() == null) {
            throw new Exception("Paciente no encontrado.");
        }
        if (patient.getId().equals(id)) {
            System.out.println("Paciente encontrado: " + patient.getName());
            return patient;
        } else {
            throw new Exception("Paciente con id " + id + " no encontrado.");
        }
    }
}
