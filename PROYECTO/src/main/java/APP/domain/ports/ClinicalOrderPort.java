
package APP.domain.ports;
import java.util.List;
import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;

public interface ClinicalOrderPort {
    
    public ClinicalOrder findById (ClinicalOrder clinicalOrder) throws Exception;
    public List<ClinicalOrder> findById (Patient patient) throws Exception;
    public void save (ClinicalOrder clinicalOrder) throws Exception;
}
