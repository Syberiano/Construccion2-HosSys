package APP.infrastructure.persistance.repository;

import APP.infrastructure.persistance.entities.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Long> {
    List<MedicamentoEntity> findByNombreContainingIgnoreCase(String nombre);
}
