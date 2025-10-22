
package APP.infrastructure.persistance.mapper;
import APP.domain.model.Patient;
import APP.domain.model.EmergencyContact;
import APP.domain.model.HealthInsurance;
import APP.domain.model.enums.Role;
import APP.infrastructure.persistance.entities.PatientEntity;
public class PatientMapper {
    
    public static PatientEntity toEntity(Patient patient) {
        if (patient == null) return null;

        PatientEntity entity = new PatientEntity();
        entity.setId(patient.getId());
        entity.setDocument(patient.getDocument());
        entity.setName(patient.getName());
        entity.setPhoneNumber(patient.getPhoneNumber());
        entity.setBirthDate(patient.getBirthDate());
        entity.setAddress(patient.getAddress());
        entity.setGender(patient.getGender());
        entity.setRole(patient.getRole());
        entity.setEmergencyContact(patient.getEmergencyContact());
        entity.setHealthInsurance(patient.getHealthInsurance());

        return entity;
    }

    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;

        return new Patient(
            entity.getId(),
            entity.getDocument(),
            entity.getName(),
            entity.getPhoneNumber(),
            entity.getBirthDate(),
            entity.getAddress(),
            entity.getGender(),
            entity.getRole(),
            entity.getEmergencyContact(),
            entity.getHealthInsurance()
        );
    }
}
