
package APP.infrastructure.persistance.mapper;
import APP.domain.model.Invoice;
import APP.infrastructure.persistance.entities.InvoiceEntity;


public class InvoiceMapper {
    
     public static InvoiceEntity toEntity(Invoice invoice) {
        if (invoice == null) return null;

        InvoiceEntity entity = new InvoiceEntity();
        entity.setPatientName(invoice.getPatientName());
        entity.setDoctorName(invoice.getDoctorName());
        entity.setInsuranceCompanyName(invoice.getInsuranceCompanyName());
        entity.setPolicyId(invoice.getPolicyId());
        entity.setPolicyStatus(invoice.isPolicyStatus());
        entity.setPolicyEndDate(invoice.getPolicyEndDate());
        entity.setStatus(invoice.getStatus());

        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) return null;

        return new Invoice(
                entity.getPatientName(),
                entity.getDoctorName(),
                entity.getInsuranceCompanyName(),
                entity.getPolicyId(),
                entity.isPolicyStatus(),
                entity.getPolicyEndDate(),
                entity.getStatus()
        );
    }
}
