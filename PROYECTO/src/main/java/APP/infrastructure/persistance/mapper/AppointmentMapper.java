
package APP.infrastructure.persistance.mapper;
import APP.domain.model.Appointment;
import APP.infrastructure.persistance.entities.AppointmentEntity;
import APP.infrastructure.persistance.entities.PatientEntity;
import APP.infrastructure.persistance.entities.DoctorEntity;

public class AppointmentMapper {
  
      public static AppointmentEntity toEntity(Appointment appointment) {
        if (appointment == null) return null;

        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(appointment.getId());

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(appointment.getPatientId());
        entity.setPatientId(patientEntity);

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(appointment.getDoctorId());
        entity.setDoctorId(doctorEntity);

        entity.setDate(appointment.getDate());
        entity.setReason(appointment.getReason());

        if (appointment.getStatus() != null) {
            entity.setStatus(AppointmentEntity.Status.valueOf(appointment.getStatus().name()));
        } else {
            entity.setStatus(AppointmentEntity.Status.PENDING);
        }

        return entity;
    }
      public static Appointment toDomain(AppointmentEntity entity) {
    if (entity == null) return null;

    Appointment appointment = new Appointment(
        entity.getId(),
        entity.getPatientId().getId(),
        entity.getDoctorId().getId(),
        entity.getDate(),
        entity.getReason(),
        null
    );

    if (entity.getStatus() != null) {
        appointment.setStatus(Appointment.Status.valueOf(entity.getStatus().name()));
    } else {
        appointment.setStatus(Appointment.Status.PENDING);
    }

    return appointment;
}

    
}
