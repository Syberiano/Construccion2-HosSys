
package APP.domain.services;

import APP.domain.model.Visit;
public class RegisterVisit {
   
    public void register(Visit visit) throws Exception {
        if (visit == null || visit.getPatient() == null || visit.getNurse() == null) {
            throw new Exception("Datos de visita invalidos");
        }
        System.out.println("La visita del paciente " 
            + visit.getPatient().getName() 
            + " fue registrada por la enfermera " 
            + visit.getNurse().getName());
    }
}
