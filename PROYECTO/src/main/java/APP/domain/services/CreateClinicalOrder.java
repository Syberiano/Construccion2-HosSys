
package APP.domain.services;

import APP.domain.model.ClinicalOrder;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.model.emuns.Role;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;


public class CreateClinicalOrder {
    private UserPort userPort;
    private PatientPort patientPort;
    private ClinicalOrderPort clinicalOrderPort;
    
    public  void crate(ClinicalOrder clinicalOrder) throws Exception{
        User doctor = userPort.findByDocument(clinicalOrder.getDoctor());
        if(doctor == null || !doctor.getRole().equals(Role.DOCTOR)){
            throw new Exception("Las ordenes solo pueden ser creadas por los doctores");
        }
        Patient patient = patientPort.findByDocument(clinicalOrder.getPatient());
        if(patient == null){
            throw new Exception("Las ordenes solo se aplican a pacientes registrados");
        }
        clinicalOrder.setPatient(patient);
        clinicalOrder.setDoctor(doctor);
        
        clinicalOrderPort.save(clinicalOrder);
    }
}
 