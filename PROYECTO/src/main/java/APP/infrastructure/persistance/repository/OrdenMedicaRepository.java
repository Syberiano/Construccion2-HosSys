package APP.infrastructure.persistance.repository;

import APP.infrastructure.persistance.entities.OrdenMedicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrdenMedicaRepository extends JpaRepository<OrdenMedicaEntity, Long> {
    List<OrdenMedicaEntity> findByPacienteId(String pacienteId);
    List<OrdenMedicaEntity> findByDoctorId(String doctorId);
}
