package APP.domain.model;

public class HealthInsurance {
    private String insuranceId;
    private String providerName;
    private String policyNumber;
    private String coverageDetails;

    public HealthInsurance() {
    }

    public HealthInsurance(String insuranceId, String providerName, String policyNumber, String coverageDetails) {
        this.insuranceId = insuranceId;
        this.providerName = providerName;
        this.policyNumber = policyNumber;
        this.coverageDetails = coverageDetails;
    }

   
    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}