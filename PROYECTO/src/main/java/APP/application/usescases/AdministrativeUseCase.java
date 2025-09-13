
package APP.application.usescases;

import APP.domain.model.Patient;
import APP.domain.model.Appointment;
import APP.domain.model.Invoice;
import APP.domain.model.EmergencyContact;
import APP.domain.services.CreatePatient;
import APP.domain.services.UpdatePatient;
import APP.domain.services.ManageAppointment;
import APP.domain.services.GenerateInvoice;
import APP.domain.services.CreateEmergencyContact;

public class AdministrativeUseCase {
    
     private CreatePatient createPatient;
    private UpdatePatient updatePatient;
    private ManageAppointment manageAppointment;
    private GenerateInvoice generateInvoice;
    private CreateEmergencyContact createEmergencyContact;

    public void createPatient(Patient patient) throws Exception {
        createPatient.create(patient);
    }

    public void updatePatient(Patient patient) throws Exception {
        updatePatient.update(patient);
    }

    public void createAppointment(Appointment appointment) throws Exception {
        manageAppointment.create(appointment);
    }

    public void createInvoice(Invoice invoice) throws Exception {
        generateInvoice.create(invoice);
    }

    public void createEmergencyContact(EmergencyContact contact) throws Exception {
        createEmergencyContact.create(contact);
    }
}
