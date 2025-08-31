
package APP.domain.model;


public class DiagnosticTest {
    
    private String id;
    private String name;
    private String description;
    private double cost;
    private Specialty specialty;

    public DiagnosticTest(String id, String name, String description, double cost, Specialty specialty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.specialty = specialty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    


   
    
}
