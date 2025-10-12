package APP.application.usescases;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.Visit;
import APP.domain.services.RegisterVisit;
import APP.domain.services.SearchPatient;
import APP.domain.services.SearchClinicalOrderByPatient;

import java.util.List;

public class NurseUseCase {
   
    private final RegisterVisit registerVisit;
    private final SearchPatient searchPatient;
    private final SearchClinicalOrderByPatient searchClinicalOrderByPatient;
    
    public NurseUseCase(
        RegisterVisit registerVisit,
        SearchPatient searchPatient,
        SearchClinicalOrderByPatient searchClinicalOrderByPatient
    ) {
        this.registerVisit = registerVisit;
        this.searchPatient = searchPatient;
        this.searchClinicalOrderByPatient = searchClinicalOrderByPatient;
    }

    public void registerVisit(Visit visit) throws Exception {
        registerVisit.register(visit);
    }

    public Patient searchPatientById(String id) throws Exception {
        return searchPatient.findById(id);
    }

    public List<ClinicalOrder> searchOrdersByPatient(Patient patient) throws Exception {
        return searchClinicalOrderByPatient.search(patient);
    }
}
