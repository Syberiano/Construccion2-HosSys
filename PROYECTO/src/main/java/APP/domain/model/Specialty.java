package APP.domain.model;

public class Specialty {
    
    private String id;
    private String name;
    private String description; 

    public Specialty(String id, String name, String description) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("El id no puede ser nulo o vacío");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        this.id = id;
        this.name = name;
        this.description = description;
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
}
