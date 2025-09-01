package APP.domain.services;

import java.util.Date;

public class RegisterHealthInsurance {
    private Date policyEndDate;
    private Boolean status;
    private String idPolicy;
    private String insuranceCompanyName;

    public RegisterHealthInsurance(Date policyEndDate, Boolean status, String idPolicy, String insuranceCompanyName) {
        this.policyEndDate = policyEndDate;
        this.status = status;
        this.idPolicy = idPolicy;
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public Date getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(Date policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getIdPolicy() {
        return idPolicy;
    }

    public void setIdPolicy(String idPolicy) {
        this.idPolicy = idPolicy;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }
}
