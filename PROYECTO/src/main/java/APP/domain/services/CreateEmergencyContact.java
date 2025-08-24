package APP.domain.services;

import APP.domain.model.EmergencyContact;
import APP.domain.ports.EmergencyContactPort;

public class CreateEmergencyContact {

    private EmergencyContactPort emergencyContactPort;

    // Constructor vacío
    public CreateEmergencyContact() {}

    // Constructor con dependencia
    public CreateEmergencyContact(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    // Setter para poder inyectar el port después
    public void setEmergencyContactPort(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public void create(EmergencyContact emergencyContact) throws Exception {
        if (emergencyContactPort.findByPhone(phone)!= null) {
            throw new Exception("Ya existe un contacto registrado con ese número de teléfono");
        }

        emergencyContactPort.save(emergencyContact);
    }
}
