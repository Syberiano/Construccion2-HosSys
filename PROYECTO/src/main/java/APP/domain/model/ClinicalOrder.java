
package APP.domain.model;

import java.util.Date;


public class ClinicalOrder {
    
    private long id;
	private Patient patient;
	private User doctor;
	private String medicine;
	private String dose;
	private Date date;

    public ClinicalOrder(long id, Patient patient, User Doctor, String medicine, String dose, Date date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.medicine = medicine;
        this.dose = dose;
        this.date = date;
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

    public void setDoctor(User Doctor) {
        this.doctor = Doctor;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
        
        
        
}
