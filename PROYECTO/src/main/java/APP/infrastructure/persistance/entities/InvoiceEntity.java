
package APP.infrastructure.persistance.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private String insuranceCompanyName;

    @Column(nullable = false, unique = true)
    private String policyId;

    @Column(nullable = false)
    private boolean policyStatus;

    @Temporal(TemporalType.DATE)
    private Date policyEndDate;

    @Column(nullable = false)
    private String status;

    public InvoiceEntity() {}

    public InvoiceEntity(String id, String patientName, String doctorName, String insuranceCompanyName, String policyId, boolean policyStatus, Date policyEndDate, String status) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.insuranceCompanyName = insuranceCompanyName;
        this.policyId = policyId;
        this.policyStatus = policyStatus;
        this.policyEndDate = policyEndDate;
        this.status = status;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public boolean isPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(boolean policyStatus) {
        this.policyStatus = policyStatus;
    }

    public Date getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(Date policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
