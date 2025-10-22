
package APP.infrastructure.persistance.mapper;

import APP.domain.model.Doctor;
import APP.infrastructure.persistance.entities.DoctorEntity;
public class DoctorMapper {
    
     public static DoctorEntity toEntity(Doctor doctor) {
        if (doctor == null) return null;

        DoctorEntity entity = new DoctorEntity();
        entity.setId(doctor.getId());
        entity.setDocument(doctor.getDocument());
        entity.setName(doctor.getName());
        entity.setPhoneNumber(doctor.getPhoneNumber());
        entity.setAddress(doctor.getAddress());
        entity.setGender(doctor.getGender());
        entity.setBirthDate(doctor.getBirthDate());
        entity.setRole(doctor.getRole());

        return entity;
    }

    
    public static Doctor toDomain(DoctorEntity entity) {
        if (entity == null) return null;

        return new Doctor(
             entity.getId(),
    entity.getDocument(),
    entity.getName(),
    entity.getPhoneNumber(),
    entity.getBirthDate(),  
    entity.getAddress(),
    entity.getGender(),
    entity.getRole()
        );
    }
}
