package APP.infrastructure.persistance.repository;

import APP.infrastructure.persistance.entities.PolizaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PolizaRepository extends JpaRepository<PolizaEntity, Long> {
    Optional<PolizaEntity> findByNumeroPoliza(String numeroPoliza);
    List<PolizaEntity> findByPacienteId(String pacienteId);
}
