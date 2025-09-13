
package APP.domain.model;

import java.util.Date;

public class Visit {
    private String id;
    private Patient patient;
    private User nurse;
    private Date date;

    public Visit(String id, Patient patient, User nurse, Date date) {
        this.id = id;
        this.patient = patient;
        this.nurse = nurse;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getNurse() {
        return nurse;
    }

    public void setNurse(User nurse) {
        this.nurse = nurse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
