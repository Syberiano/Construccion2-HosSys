package APP.domain.ports;
import java.util.List;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;

public interface ClinicalOrderPort {
    

    ClinicalOrder findById(Long id) throws Exception;

    List<ClinicalOrder> findByPatient(Patient patient) throws Exception;

    void save(ClinicalOrder clinicalOrder) throws Exception;
}
