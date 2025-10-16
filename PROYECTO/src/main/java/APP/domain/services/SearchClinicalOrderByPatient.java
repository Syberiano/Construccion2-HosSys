
package APP.domain.services;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import java.util.ArrayList;
import java.util.List;
public class SearchClinicalOrderByPatient {
    
     private List<ClinicalOrder> orders = new ArrayList<>();

    public List<ClinicalOrder> search(Patient patient) throws Exception {
        if (patient == null || patient.getId() == null) {
            throw new Exception("Paciente invalido");
        }

        List<ClinicalOrder> result = new ArrayList<>();
        for (ClinicalOrder order : orders) {
            if (order.getPatient() != null && order.getPatient().getId().equals(patient.getId())) {
                result.add(order);
            }
        }

        if (result.isEmpty()) {
            throw new Exception("No se encontraron ordenes clinicas para el paciente: " + patient.getName());
        }

        return result;
    }
}
