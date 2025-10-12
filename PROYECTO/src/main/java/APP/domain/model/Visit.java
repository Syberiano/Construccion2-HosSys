package APP.domain.model;

import java.util.Date;

public class Visit {
    private String id;
    private Patient patient;
    private User nurse;
    private Date date;

    public Visit(String id, Patient patient, User nurse, Date date) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("El id no puede ser nulo o vacío");
        if (patient == null) throw new IllegalArgumentException("El paciente no puede ser nulo");
        if (nurse == null) throw new IllegalArgumentException("La enfermera no puede ser nula");
        if (date == null) throw new IllegalArgumentException("La fecha no puede ser nula");
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
