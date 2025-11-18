package APP.domain.services;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import APP.infrastructure.persistance.entities.VitalSignEntity;
import APP.infrastructure.persistance.repository.VitalSignRepository;

@Service
public class RegisterVitalSigns {
    
    @Autowired
    private VitalSignRepository vitalSignRepo;

    public RegisterVitalSigns() {
        // constructor vacío, usamos JPA para persistencia
    }

    public VitalSignEntity register(String patientId, String bloodPressure, int heartRate, double temperature, double weight) throws Exception {
        if (patientId == null || patientId.isEmpty()) {
            throw new Exception("El ID del paciente es obligatorio");
        }
        if (heartRate <= 0 || temperature <= 0 || weight <= 0) {
            throw new Exception("Los valores de los signos vitales deben ser mayores a 0");
        }

        VitalSignEntity entity = new VitalSignEntity(patientId, bloodPressure, heartRate, temperature, weight, new Date());
        vitalSignRepo.save(entity);
        System.out.println("Signos vitales registrados para el paciente " + patientId + " (id registro: " + entity.getId() + ")");
        return entity;
    }

    public VitalSignEntity getLatest(String patientId) throws Exception {
        List<VitalSignEntity> list = vitalSignRepo.findByPatientIdOrderByRecordedAtDesc(patientId);
        if (list == null || list.isEmpty()) {
            throw new Exception("No se encontraron signos vitales para el paciente con ID: " + patientId);
        }
        return list.get(0);
    }

    public List<VitalSignEntity> getAll(String patientId) {
        return vitalSignRepo.findByPatientIdOrderByRecordedAtDesc(patientId);
    }
}
