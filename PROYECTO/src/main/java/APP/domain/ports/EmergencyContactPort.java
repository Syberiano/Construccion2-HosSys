package APP.domain.ports;

import APP.domain.model.EmergencyContact;

public interface EmergencyContactPort {

    EmergencyContact findByPhone(String phone);

    void save(EmergencyContact emergencyContact);
}
