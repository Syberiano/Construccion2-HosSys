package APP.domain.model;

import java.util.Date;


public class Appointment {
    
    public enum Status {
        PENDING, COMPLETED, CANCELLED
    }

    private String id;
    private String patientId;
    private String doctorId;
    private Date date;
    private String reason;
    private Status status; 

    public Appointment(String id, String patientId, String doctorId, Date date, String reason, Status status) {
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

    public Status getStatus() {
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

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
