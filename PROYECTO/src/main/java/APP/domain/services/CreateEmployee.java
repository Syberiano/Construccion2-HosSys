
package APP.domain.services;

import APP.domain.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class CreateEmployee {
    
     private List<Employee> employees = new ArrayList<>();

    public void create(Employee employee) throws Exception {
        if (employee == null || employee.getId() == null || employee.getId().isEmpty()) {
            throw new Exception("El empleado no es válido");
        }

        for (Employee e : employees) {
            if (e.getId().equals(employee.getId())) {
                throw new Exception("Ya existe un empleado con el ID: " + employee.getId());
            }
        }

        employees.add(employee);
        System.out.println("Empleado " + employee.getName() + " creado exitosamente.");
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
