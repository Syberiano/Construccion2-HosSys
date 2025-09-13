
package APP.application.usescases;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.Visit;
import APP.domain.services.RegisterVisit;
import APP.domain.services.SearchPatient;
import APP.domain.services.SearchClinicalOrderByPatient;

import java.util.List;

public class NurseUseCase {
   
    private RegisterVisit registerVisit;
    private SearchPatient searchPatient;
    private SearchClinicalOrderByPatient searchClinicalOrderByPatient;
    
    public void registerVisit(Visit visit) throws Exception {
        registerVisit.register(visit);
    }

    public Patient searchPatientById(Patient patient, String id) throws Exception {
        return searchPatient.findById(patient, id);
    }

    public List<ClinicalOrder> searchOrdersByPatient(Patient patient) throws Exception {
        return searchClinicalOrderByPatient.search(patient);
    }
}
