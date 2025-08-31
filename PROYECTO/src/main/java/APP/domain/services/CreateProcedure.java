
package APP.domain.services;

import APP.domain.model.Procedure;


public class CreateProcedure {
    
    public void create (Procedure procedure) throws Exception{ 
        if (procedure == null) {
            throw new Exception("El procedimineto no puede ser nulo");  
        }
        if (procedure.getName() == null || procedure.getName().isEmpty()) {
            throw new Exception("El nombre del procedimineto es obligatorio");
        }
        if (procedure.getCost() <= 0) {
            throw new Exception("El costo del procedimiento debe ser mayor a 0");
        }
        System.out.println("Procedimeinto registrado: " + procedure.getName()+ " con costo de: " + procedure.getCost());
    }
}
