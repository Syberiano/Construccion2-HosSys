
package APP.domain.services;

import APP.domain.model.Invoice;
import java.util.HashMap;
import java.util.Map;
public class CopayControl {
   
     private Map<String, Double> copays;

    public CopayControl() {
        this.copays = new HashMap<>();
    }

    public void calculateCopay(Invoice invoice, double totalAmount, double percentage) throws Exception {
        if (invoice == null) {
            throw new Exception("La factura no puede ser nula");
        }
        if (totalAmount <= 0) {
            throw new Exception("El monto total debe ser mayor a cero");
        }
        if (percentage <= 0 || percentage > 100) {
            throw new Exception("El porcentaje debe estar entre 1 y 100 %");
        }

        double copayAmount = (totalAmount * percentage) / 100;
        copays.put(invoice.getPolicyId(), copayAmount);

        System.out.println("Copago calculado para la póliza " + invoice.getPolicyId() + ": $" + copayAmount);
    }

    public void showCopay(String policyId) throws Exception {
        if (!copays.containsKey(policyId)) {
            throw new Exception("No se encontró copago para la póliza " + policyId);
        }
        System.out.println("Copago de la póliza " + policyId + ": $" + copays.get(policyId));
    }
}
