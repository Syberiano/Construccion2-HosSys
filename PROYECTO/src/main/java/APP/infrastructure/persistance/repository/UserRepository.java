
package APP.infrastructure.persistance.repository;

import APP.infrastructure.persistance.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByDocument(String document);

    java.util.Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
}
