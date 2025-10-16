
package APP.domain.services;

import APP.domain.model.Employee;
import java.util.List;

public class UpdateEmployee {
    
    private List<Employee> employees;

    public UpdateEmployee(List<Employee> employees) {
        this.employees = employees;
    }

    public void update(Employee employee) throws Exception {
        if (employee == null || employee.getId() == null || employee.getId().isEmpty()) {
            throw new Exception("El empleado no es valido");
        }

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(employee.getId())) {
                employees.set(i, employee);
                System.out.println("Empleado " + employee.getName() + " actualizado correctamente.");
                return;
            }
        }

        throw new Exception("No se encontro un empleado con el ID: " + employee.getId());
    }
}
