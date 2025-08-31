
package APP.domain.model;

import java.util.Date;

public class Invoice {
    private String patientName;
    private String doctorName;
    private String insuranceCompanyName;
    private String policyId;
    private boolean policyStatus;
    private Date policyEndDate;

    public Invoice(String patientName, String doctorName, String insuranceCompanyName, String policyId, boolean policyStatus, Date policyEndDate) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.insuranceCompanyName = insuranceCompanyName;
        this.policyId = policyId;
        this.policyStatus = policyStatus;
        this.policyEndDate = policyEndDate;
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
    
    
}
