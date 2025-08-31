
package APP.domain.model;

import java.util.Date;


public class Appointment {
    
    private String id;
    private String patientId;
    private String doctorId;
    private Date date;
    private String reason;
    private String status; 

    public Appointment(String id, String patientId, String doctorId, Date date, String reason, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.reason = reason;
        this.status = status;
    }
    
    

    public String getId() {
        return id;
    }

    public String getPatientId() { 
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public Date getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
