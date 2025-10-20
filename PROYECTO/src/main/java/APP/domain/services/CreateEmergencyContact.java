package APP.domain.services;

import APP.domain.model.EmergencyContact;
import APP.domain.ports.EmergencyContactPort;

public class CreateEmergencyContact {

    private final EmergencyContactPort emergencyContactPort;

    public CreateEmergencyContact(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public void create(EmergencyContact emergencyContact) throws Exception {
        if (emergencyContact == null) {
            throw new Exception("El contacto de emergencia no puede ser nulo");
        }
        if (emergencyContact.getPhoneNumber() == null || emergencyContact.getPhoneNumber().isEmpty()) {
            throw new Exception("El número de teléfono es obligatorio");
        }
        if (emergencyContactPort.findByPhone(emergencyContact.getPhoneNumber()) != null) {
            throw new Exception("Ya existe un contacto registrado con ese número de teléfono");
        }
        emergencyContactPort.save(emergencyContact);
    }
}
