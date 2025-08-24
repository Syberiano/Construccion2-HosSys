package APP.domain.services;

import APP.domain.model.EmergencyContact;
import APP.domain.ports.EmergencyContactPort;

public class CreateEmergencyContact {

    private EmergencyContactPort emergencyContactPort;

    
    public CreateEmergencyContact() {}

    
    public CreateEmergencyContact(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    
    public void setEmergencyContactPort(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public void create(EmergencyContact emergencyContact) throws Exception {
        if (emergencyContactPort.findByPhone(emergencyContact.getPhoneNumber()) != null) {
            throw new Exception("Ya existe un contacto registrado con ese número de teléfono");
        }

        emergencyContactPort.save(emergencyContact);
    }
}
