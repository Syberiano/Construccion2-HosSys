package APP.domain.model;
import jakarta.persistence.Embeddable;

@Embeddable

public class HealthInsurance {
    private String insuranceId;
    private String providerName;
    private String policyNumber;
    private String coverageDetails;

    public HealthInsurance() {
    }

    public HealthInsurance(String insuranceId, String providerName, String policyNumber, String coverageDetails) {
        if (insuranceId == null || insuranceId.isEmpty()) throw new IllegalArgumentException("El ID del seguro no puede ser nulo o vacío");
        if (providerName == null || providerName.isEmpty()) throw new IllegalArgumentException("El proveedor no puede ser nulo o vacío");
        if (policyNumber == null || policyNumber.isEmpty()) throw new IllegalArgumentException("El número de póliza no puede ser nulo o vacío");
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

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }
}