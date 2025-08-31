
package APP.domain.services;

import APP.domain.model.DiagnosticTest;
import APP.domain.model.Procedure;
import APP.domain.model.Specialty;


public class AssignSpecialty {
    
    public void assignToProcedure(Procedure procedure , Specialty specialty) throws Exception{
        if (procedure == null || specialty == null) {
            throw new Exception("El procedimiento y l aespecialidad son obligatorios ");
        }
        procedure.setSpecialty(specialty);
        System.out.println("Especialidad " + specialty.getName() + "asignada al procedimiento " + procedure.getName());
        
    }
    public void assignToDiagnostic(DiagnosticTest diagnostic, Specialty specialty)throws Exception{
        if (diagnostic == null || specialty == null) {
            throw new Exception("El diagnostico y la especialidad son obligatorios");
            
        }
        diagnostic.setSpecialty(specialty);
        System.out.println("Especialidad" + specialty.getName() + "asignada a la ayuda diagnostica" + diagnostic.getName());
    }
    
}
