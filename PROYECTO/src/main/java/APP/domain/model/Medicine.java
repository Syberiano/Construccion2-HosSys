package APP.domain.model;

public class Medicine {
    
    private String id;
    private String name;
    private String description;
    private double cost; 

    public Medicine(String id, String name, String description, double cost) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("El id no puede ser nulo o vacío");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        if (cost < 0) throw new IllegalArgumentException("El costo no puede ser negativo");
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
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

    public void setId(String id) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("El id no puede ser nulo o vacío");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        if (cost < 0) throw new IllegalArgumentException("El costo no puede ser negativo");
        this.cost = cost;
    }
}
