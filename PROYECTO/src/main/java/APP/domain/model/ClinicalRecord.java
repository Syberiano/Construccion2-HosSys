
package APP.domain.model;

import java.util.Date;


public class ClinicalRecord {
    private long id;
    private Patient patient;
    private User doctor;
    private Date date;
    private String motive;
    private String diagnosis;
    private String symptoms;
    private ClinicalOrder clinicalOrder;

    public ClinicalRecord(long id, Patient patient, User doctor, Date date, String motive, String diagnosis, String symptoms, ClinicalOrder clinicalOrder) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.motive = motive;
        this.diagnosis = diagnosis;
        this.symptoms = symptoms;
        this.clinicalOrder = clinicalOrder;
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

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public ClinicalOrder getClinicalOrder() {
        return clinicalOrder;
    }

    public void setClinicalOrder(ClinicalOrder clinicalOrder) {
        this.clinicalOrder = clinicalOrder;
    }

    
    
    
   
}
