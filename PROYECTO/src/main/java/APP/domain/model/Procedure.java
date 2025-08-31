
package APP.domain.model;


public class Procedure {
    
    private String id;
    private String name;
    private String description;
    private double cost;
    private String specialtyId;

    public Procedure(String id, String name, String description, double cost, String specialtyId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.specialtyId = specialtyId;
    }
    
    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }
    
}
