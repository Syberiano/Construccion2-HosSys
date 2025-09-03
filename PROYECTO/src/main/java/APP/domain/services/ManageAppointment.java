
package APP.domain.services;

import APP.domain.model.Appointment;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class ManageAppointment {
    private List<Appointment> appointments;

    public ManageAppointment() {
        this.appointments = new ArrayList<>();
    }

    public void create(Appointment appointment) throws Exception {
        if (appointment == null) {
            throw new Exception("La cita no puede ser nula");
        }
        if (appointment.getDate() == null || appointment.getDate().before(new Date())) {
            throw new Exception("La fecha de la cita no es válida");
        }
        if (appointment.getPatientId() == null || appointment.getPatientId().isEmpty()) {
            throw new Exception("El ID del paciente es obligatorio");
        }
        if (appointment.getDoctorId() == null || appointment.getDoctorId().isEmpty()) {
            throw new Exception("El ID del médico es obligatorio");
        }

        appointment.setStatus("PROGRAMADA");
        appointments.add(appointment);
        System.out.println("Cita creada exitosamente con ID: " + appointment.getId());
    }

    public void cancel(String appointmentId) throws Exception {
        Appointment appointment = null;
        for (Appointment a : appointments) {
            if (a.getId().equals(appointmentId)) {
                appointment = a;
                break;
            }
        }

        if (appointment == null) {
            throw new Exception("No se encontró la cita con ID: " + appointmentId);
        }

        appointment.setStatus("CANCELADA");
        System.out.println("Cita cancelada con ID: " + appointmentId);
    }

    public List<Appointment> listAll() {
        return new ArrayList<>(appointments);
    }

    public List<Appointment> listByPatient(String patientId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getPatientId().equals(patientId)) {
                result.add(a);
            }
        }
        return result;
    }

    public List<Appointment> listByDoctor(String doctorId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getDoctorId().equals(doctorId)) {
                result.add(a);
            }
        }
        return result;
    }
}
