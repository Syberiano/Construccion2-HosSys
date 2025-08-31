
package APP.domain.model;


public class DiagnosticOrder {
    
    private String orderId;
    private int itemNumber;
    private String diagnosticId;
    private String diagnosticName;
    private int quantity;
    private double cost;
    private boolean requiresSpecialist;
    private String specialtyId;

    public DiagnosticOrder(String orderId, int itemNumber, String diagnosticId, String diagnosticName, int quantity, double cost, boolean requiresSpecialist, String specialtyId) {
        this.orderId = orderId;
        this.itemNumber = itemNumber;
        this.diagnosticId = diagnosticId;
        this.diagnosticName = diagnosticName;
        this.quantity = quantity;
        this.cost = cost;
        this.requiresSpecialist = requiresSpecialist;
        this.specialtyId = specialtyId;
    }
    
    

    public String getOrderId() {
        return orderId;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getDiagnosticId() {
        return diagnosticId;
    }

    public String getDiagnosticName() {
        return diagnosticName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setDiagnosticId(String diagnosticId) {
        this.diagnosticId = diagnosticId;
    }

    public void setDiagnosticName(String diagnosticName) {
        this.diagnosticName = diagnosticName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }
    
}
