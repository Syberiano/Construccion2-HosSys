
package APP.infrastructure.persistance.repository;
import APP.infrastructure.persistance.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository< PatientEntity, String>{
    
     boolean existsByDocument(String document);
}
