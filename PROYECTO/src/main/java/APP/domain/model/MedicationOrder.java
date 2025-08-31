
package APP.domain.model;


public class MedicationOrder {
     private String orderId;
     private int itemNumber;
     private String medicineId;
     private String medicineName;
     private String dose;
     private String duration;
     private double cost;

    public MedicationOrder(String orderId, int itemNumber, String medicineId, String medicineName, String dose, String duration, double cost) {
        this.orderId = orderId;
        this.itemNumber = itemNumber;
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.dose = dose;
        this.duration = duration;
        this.cost = cost;
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

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
     
     
}
