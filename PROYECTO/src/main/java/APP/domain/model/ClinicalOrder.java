
package APP.domain.model;

import java.util.Date;
import java.util.List;


public class ClinicalOrder {
    
        private long id;
	private Patient patient;
	private User doctor;
	private Date date;
        private List<MedicationOrder> medications;
        private List<ProcedureOrder> procedures;
        private List<DiagnosticOrder> diagnostics;

    public ClinicalOrder(long id, Patient patient, User doctor, Date date, List<MedicationOrder> medications, List<ProcedureOrder> procedures, List<DiagnosticOrder> diagnostics) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.medications = medications;
        this.procedures = procedures;
        this.diagnostics = diagnostics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<MedicationOrder> getMedications() {
        return medications;
    }

    public void setMedications(List<MedicationOrder> medications) {
        this.medications = medications;
    }

    public List<ProcedureOrder> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<ProcedureOrder> procedures) {
        this.procedures = procedures;
    }

    public List<DiagnosticOrder> getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(List<DiagnosticOrder> diagnostics) {
        this.diagnostics = diagnostics;
    }
        
        
}
