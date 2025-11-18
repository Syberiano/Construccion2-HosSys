package APP.infrastructure.persistance.repository;

import APP.infrastructure.persistance.entities.EnfermeraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EnfermeraRepository extends JpaRepository<EnfermeraEntity, String> {
    boolean existsByDocument(String document);
    Optional<EnfermeraEntity> findByDocument(String document);
}

