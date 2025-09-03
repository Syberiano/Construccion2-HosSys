
package APP.domain.services;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
public class RegisterVitalSigns {
    
     private Map<String, Map<String, String>> vitalSignsRegistry;

    public RegisterVitalSigns() {
        this.vitalSignsRegistry = new HashMap<>();
    }

    public void register(String patientId, String bloodPressure, int heartRate, double temperature, double weight) throws Exception {
        if (patientId == null || patientId.isEmpty()) {
            throw new Exception("El ID del paciente es obligatorio");
        }
        if (heartRate <= 0 || temperature <= 0 || weight <= 0) {
            throw new Exception("Los valores de los signos vitales deben ser mayores a 0");
        }

        Map<String, String> vitals = new HashMap<>();
        vitals.put("Presion Arterial", bloodPressure);
        vitals.put("Frecuencia Cardiaca", heartRate + " lpm");
        vitals.put("Temperatura", temperature + " °C");
        vitals.put("Peso", weight + " kg");
        vitals.put("Fecha Registro", new Date().toString());

        vitalSignsRegistry.put(patientId, vitals);
        System.out.println("Signos vitales registrados para el paciente " + patientId);
    }

    public Map<String, String> getVitalSigns(String patientId) throws Exception {
        if (!vitalSignsRegistry.containsKey(patientId)) {
            throw new Exception("No se encontraron signos vitales para el paciente con ID: " + patientId);
        }
        return vitalSignsRegistry.get(patientId);
    }
}
