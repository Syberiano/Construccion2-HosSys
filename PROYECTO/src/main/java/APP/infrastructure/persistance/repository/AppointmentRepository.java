
package APP.infrastructure.persistance.repository;

import APP.infrastructure.persistance.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, String>{
    
}
