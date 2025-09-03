
package APP.domain.services;
import APP.domain.model.Invoice;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class GenerateInvoice {
    
  private List<Invoice> invoices;

    public GenerateInvoice() {
        this.invoices = new ArrayList<>();
    }

    public void create(Invoice invoice) throws Exception {
        if (invoice == null) {
            throw new Exception("La factura no puede ser nula");
        }
        if (invoice.getPatientName() == null || invoice.getPatientName().isEmpty()) {
            throw new Exception("El nombre del paciente es obligatorio");
        }
        if (invoice.getDoctorName() == null || invoice.getDoctorName().isEmpty()) {
            throw new Exception("El nombre del doctor es obligatorio");
        }
        if (invoice.getInsuranceCompanyName() == null || invoice.getInsuranceCompanyName().isEmpty()) {
            throw new Exception("La compañía de seguros es obligatoria");
        }
        if (invoice.getPolicyId() == null || invoice.getPolicyId().isEmpty()) {
            throw new Exception("El ID de la póliza es obligatorio");
        }
        if (!invoice.isPolicyStatus()) {
            throw new Exception("La póliza no está activa");
        }
        if (invoice.getPolicyEndDate() == null || invoice.getPolicyEndDate().before(new Date())) {
            throw new Exception("La póliza está vencida");
        }

        invoice.setStatus("GENERADA");
        invoices.add(invoice);
        System.out.println("Factura creada para paciente: " + invoice.getPatientName());
    }

    public void payInvoice(String policyId) throws Exception {
        Invoice invoice = findByPolicyId(policyId);
        if (invoice == null) {
            throw new Exception("No se encontró la factura con la póliza " + policyId);
        }
        if (invoice.getStatus().equals("PAGADA")) {
            throw new Exception("La factura ya está pagada");
        }
        invoice.setStatus("PAGADA");
        System.out.println("Factura con póliza " + policyId + " ha sido pagada.");
    }

    public void listAll() {
        if (invoices.isEmpty()) {
            System.out.println("No hay facturas registradas.");
        } else {
            for (Invoice invoice : invoices) {
                String policyState;
                if (invoice.isPolicyStatus()) {
                    policyState = "Activa";
                } else {
                    policyState = "Inactiva";
                }
                System.out.println("Factura -> Paciente: " + invoice.getPatientName()
                        + ", Doctor: " + invoice.getDoctorName()
                        + ", Aseguradora: " + invoice.getInsuranceCompanyName()
                        + ", Póliza: " + invoice.getPolicyId()
                        + ", Estado Póliza: " + policyState
                        + ", Vencimiento: " + invoice.getPolicyEndDate()
                        + ", Estado Factura: " + invoice.getStatus());
            }
        }
    }

    private Invoice findByPolicyId(String policyId) {
        for (Invoice invoice : invoices) {
            if (invoice.getPolicyId().equals(policyId)) {
                return invoice;
            }
        }
        return null;
    }

}
