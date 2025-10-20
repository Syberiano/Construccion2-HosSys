package APP.domain.model;


public class Employee {
    
    private String id;
    private String name;
    private String role;
    private String department;

    public Employee(String id, String name, String role, String department) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("El id no puede ser nulo o vacío");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        if (role == null || role.isEmpty()) throw new IllegalArgumentException("El rol no puede ser nulo o vacío");
        if (department == null || department.isEmpty()) throw new IllegalArgumentException("El departamento no puede ser nulo o vacío");
        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
}
