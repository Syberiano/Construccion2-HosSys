package APP.application.usescases;

import APP.domain.model.Employee;
import APP.domain.services.CreateEmployee;
import APP.domain.services.UpdateEmployee;
import java.util.List;

public class RrhhUseCase {
    
    private final CreateEmployee createEmployee;
    private final UpdateEmployee updateEmployee;

    public RrhhUseCase(CreateEmployee createEmployee, UpdateEmployee updateEmployee) {
        this.createEmployee = createEmployee;
        this.updateEmployee = updateEmployee;
    }

    public void createEmployee(Employee employee) throws Exception {
        createEmployee.create(employee);
    }

    public void updateEmployee(Employee employee) throws Exception {
        updateEmployee.update(employee);
    }

    public List<Employee> getAllEmployees() {
        return createEmployee.getEmployees();
    }
}
