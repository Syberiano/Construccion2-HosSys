package APP.infrastructure.persistance.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ordenes_medicas")
public class OrdenMedicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private PatientEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor", nullable = false)
    private DoctorEntity doctor;

    private LocalDateTime fecha;
    private String estado;

    @Column(length = 1000)
    private String descripcion;

    @Column(length = 500)
    private String diagnostico;

    @Column(length = 1000)
    private String observaciones;

    @ManyToMany
    @JoinTable(
        name = "orden_medicamento",
        joinColumns = @JoinColumn(name = "orden_id"),
        inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<MedicamentoEntity> medicamentosPrescritos;

    public OrdenMedicaEntity() { 
        this.fecha = LocalDateTime.now(); 
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public PatientEntity getPaciente() { return paciente; }
    public void setPaciente(PatientEntity paciente) { this.paciente = paciente; }
    public DoctorEntity getDoctor() { return doctor; }
    public void setDoctor(DoctorEntity doctor) { this.doctor = doctor; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public List<MedicamentoEntity> getMedicamentosPrescritos() { return medicamentosPrescritos; }
    public void setMedicamentosPrescritos(List<MedicamentoEntity> medicamentosPrescritos) { this.medicamentosPrescritos = medicamentosPrescritos; }
}
