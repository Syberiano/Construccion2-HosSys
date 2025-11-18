package APP.infrastructure.persistance.repository;

import APP.infrastructure.persistance.entities.RrhhEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RrhhRepository extends JpaRepository<RrhhEntity, String> {
    boolean existsByDocument(String document);
    Optional<RrhhEntity> findByDocument(String document);
}

