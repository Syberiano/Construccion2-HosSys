package APP.domain.services;

import APP.domain.model.Patient;
import APP.domain.model.HealthInsurance;
import APP.domain.model.EmergencyContact;
import APP.domain.ports.PatientPort;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class CreatePatient {
    
    private final PatientPort patientPort;
    
    public CreatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }
    
    public void create(Patient patient) throws IllegalArgumentException, Exception {
        if (patient == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo");
        }
        
        validatePatientData(patient);
        validateAge(patient.getBirthDate());
        
        if (patientPort.existsById(patient.getId())) {
            throw new IllegalArgumentException("Ya existe un paciente con el ID: " + patient.getId());
        }
        
        if (patientPort.existsByDocument(patient.getDocument())) {
            throw new IllegalArgumentException("Ya existe un paciente con el documento: " + patient.getDocument());
        }
        
        patientPort.save(patient);
    }
    
    private void validatePatientData(Patient patient) {
        if (patient.getId() == null || patient.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del paciente es requerido");
        }
        
        if (patient.getDocument() == null || patient.getDocument().trim().isEmpty()) {
            throw new IllegalArgumentException("El documento del paciente es requerido");
        }
        
        if (patient.getName() == null || patient.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del paciente es requerido");
        }
        
        if (patient.getPhoneNumber() == null || patient.getPhoneNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("El numero de telefono es requerido");
        }
        
        if (patient.getBirthDate() == null) {
            throw new IllegalArgumentException("La fecha de nacimiento es requerida");
        }
        
        if (patient.getAddress() == null || patient.getAddress().trim().isEmpty()) {
            throw new IllegalArgumentException("La direccion es requerida");
        }
        
        if (patient.getGender() == null || patient.getGender().trim().isEmpty()) {
            throw new IllegalArgumentException("El genero es requerido");
        }
        
        if (patient.getEmergencyContact() == null) {
            throw new IllegalArgumentException("El contacto de emergencia es requerido");
        }
        
        if (patient.getHealthInsurance() == null) {
            throw new IllegalArgumentException("El seguro medico es requerido");
        }
    }
    
    private void validateAge(Date birthDate) {
        LocalDate birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int age = Period.between(birthLocalDate, LocalDate.now()).getYears();
        
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("La fecha de nacimiento no es valida");
        }
        
        if (age < 18 && age > 0){
            System.out.println("Advertencia: Paciente menor de edad. Verificar representante legal.");
        }
    }
}

