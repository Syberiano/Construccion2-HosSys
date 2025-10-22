
package APP.infrastructure.persistance.repository;

import APP.infrastructure.persistance.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, String>{
    
    boolean existsByDocument(String document);
}
