package APP.infrastructure.persistance.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vital_signs")
public class VitalSignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patientId;

    @Column(length = 100)
    private String bloodPressure;

    private Integer heartRate;

    private Double temperature;

    private Double weight;

    @Temporal(TemporalType.TIMESTAMP)
    private Date recordedAt;

    public VitalSignEntity() {}

    public VitalSignEntity(String patientId, String bloodPressure, Integer heartRate, Double temperature, Double weight, Date recordedAt) {
        this.patientId = patientId;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.weight = weight;
        this.recordedAt = recordedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    public Integer getHeartRate() { return heartRate; }
    public void setHeartRate(Integer heartRate) { this.heartRate = heartRate; }
    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
    public Date getRecordedAt() { return recordedAt; }
    public void setRecordedAt(Date recordedAt) { this.recordedAt = recordedAt; }
}

