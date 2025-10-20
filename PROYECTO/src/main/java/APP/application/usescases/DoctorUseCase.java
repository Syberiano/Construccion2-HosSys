package APP.application.usescases;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.services.CreateClinicalOrder;
import APP.domain.services.CreateClinicalRecord;
import APP.domain.services.SearchClinicalRecord;
import APP.domain.services.UpdateClinicalRecord;
import java.util.List;

public class DoctorUseCase {
    
    private final CreateClinicalRecord createClinicalRecord;
    private final UpdateClinicalRecord updateClinicalRecord;
    private final CreateClinicalOrder createClinicalOrder;
    private final SearchClinicalRecord searchClinicalRecord;

    public DoctorUseCase(
        CreateClinicalRecord createClinicalRecord,
        UpdateClinicalRecord updateClinicalRecord,
        CreateClinicalOrder createClinicalOrder,
        SearchClinicalRecord searchClinicalRecord
    ) {
        this.createClinicalRecord = createClinicalRecord;
        this.updateClinicalRecord = updateClinicalRecord;
        this.createClinicalOrder = createClinicalOrder;
        this.searchClinicalRecord = searchClinicalRecord;
    }
    
    public List<ClinicalRecord> searchHistory(String patientId) throws Exception {
        return searchClinicalRecord.findByPatient(patientId);
    }

    public void createMedicalRecord(ClinicalRecord record) throws Exception {
        createClinicalRecord.create(record);
    }

    public void updateMedicalRecord(ClinicalRecord record) throws Exception {
        updateClinicalRecord.update(record);
    }

    public void createOrder(ClinicalOrder order) throws Exception {
        createClinicalOrder.create(order);
    }
}
