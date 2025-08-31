
package APP.domain.model;

public class ProcedureOrder {
    
     private String orderId;
    private int itemNumber;
    private String procedureId;
    private String procedureName;
    private int repetitions;
    private int frequency;
    private double cost;
    private boolean requiresSpecialist;
    private String specialtyId;

    public ProcedureOrder(String orderId, int itemNumber, String procedureId, String procedureName, int repetitions, int frequency, double cost, boolean requiresSpecialist, String specialtyId) {
        this.orderId = orderId;
        this.itemNumber = itemNumber;
        this.procedureId = procedureId;
        this.procedureName = procedureName;
        this.repetitions = repetitions;
        this.frequency = frequency;
        this.cost = cost;
        this.requiresSpecialist = requiresSpecialist;
        this.specialtyId = specialtyId;
    }
    
    

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }
   
}
