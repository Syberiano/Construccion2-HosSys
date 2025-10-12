package APP.domain.ports;

import APP.domain.model.EmergencyContact;
import APP.domain.model.Patient;
import java.util.List;

public interface EmergencyContactPort {

    EmergencyContact findById(Long id) throws Exception;

    EmergencyContact findByPhone(String phone) throws Exception;

    List<EmergencyContact> findByPatient(Patient patient) throws Exception;

    void save(EmergencyContact emergencyContact) throws Exception;
}
