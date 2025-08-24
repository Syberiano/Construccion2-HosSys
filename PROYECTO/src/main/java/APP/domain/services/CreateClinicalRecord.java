
package APP.domain.services;


import APP.domain.model.ClinicalOrder;
import APP.domain.model.ClinicalRecord;
import APP.domain.model.Patient;
import APP.domain.model.User;
import APP.domain.model.emuns.Role;
import APP.domain.ports.ClinicalOrderPort;
import APP.domain.ports.ClinicalRecordPort;
import APP.domain.ports.PatientPort;
import APP.domain.ports.UserPort;
public class CreateClinicalRecord {
    
    private UserPort userPort;
    private PatientPort patientPort;
    private ClinicalOrderPort clinicalOrderPort;
    private  ClinicalRecordPort clinicalRecordPort;
    
    public  void create(ClinicalRecord clinicalRecord) throws Exception{
        Patient patient = patientPort.findByDocument(clinicalRecord.getPatient());
        if(patient == null){
            throw new Exception("La histoia clinica debe tener un paciente valido");
        }
        User doctor = userPort.findByDocument(clinicalRecord.getDoctor());
        if(doctor == null || !doctor.getRole().equals(Role.DOCTOR)){
            throw new Exception("Laa historia clinica debe ser creada por un doctor valido");
        }
        ClinicalOrder clinicalOrder = clinicalOrderPort.findById(clinicalRecord.getClinicalOrder());
        if(clinicalOrder == null){
            throw new Exception("L historia clinica debe tener una orden valida");
        }
        
        clinicalRecord.setPatient(patient);
        clinicalRecord.setClinicalOrder(clinicalOrder);
        clinicalRecord.setDoctor(doctor);
        clinicalRecordPort.save(clinicalRecord);
    }
}
