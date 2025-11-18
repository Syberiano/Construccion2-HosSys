package APP.infrastructure.persistance.mapper;
import APP.domain.model.Invoice;
import APP.infrastructure.persistance.entities.InvoiceEntity;


public class InvoiceMapper {
    
     public static InvoiceEntity toEntity(Invoice invoice) {
        if (invoice == null) return null;

        InvoiceEntity entity = new InvoiceEntity();
        // InvoiceEntity ahora usa relaciones, así que mapeamos los campos disponibles
        entity.setInsuranceCompanyName(invoice.getInsuranceCompanyName());
        entity.setPolicyId(invoice.getPolicyId());
        entity.setStatus(invoice.getStatus());
        // Nota: patientName y doctorName ahora vienen de las relaciones
        // Si necesitas mapear desde Invoice domain, necesitarías pasar las entidades

        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) return null;

        // Extraer nombres de las relaciones
        String patientName = entity.getPaciente() != null ? entity.getPaciente().getName() : "";
        String doctorName = entity.getOrdenMedica() != null && entity.getOrdenMedica().getDoctor() != null 
            ? entity.getOrdenMedica().getDoctor().getName() : "";
        
        // Usar valores por defecto para campos que ya no existen
        boolean policyStatus = entity.getPolicyId() != null && !entity.getPolicyId().isEmpty();
        java.util.Date policyEndDate = new java.util.Date(); // Ya no se almacena en InvoiceEntity
        
        return new Invoice(
                patientName,
                doctorName,
                entity.getInsuranceCompanyName() != null ? entity.getInsuranceCompanyName() : "",
                entity.getPolicyId() != null ? entity.getPolicyId() : "",
                policyStatus,
                policyEndDate,
                entity.getStatus() != null ? entity.getStatus() : "PENDIENTE"
        );
    }
}
