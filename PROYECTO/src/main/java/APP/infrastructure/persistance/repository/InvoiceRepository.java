
package APP.infrastructure.persistance.repository;

import APP.infrastructure.persistance.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, String>{
    
}
