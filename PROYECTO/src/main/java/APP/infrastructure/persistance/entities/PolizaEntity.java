package APP.infrastructure.persistance.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "polizas")
public class PolizaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String numeroPoliza;

    private String asegurado;

    private LocalDate vigenciaInicio;
    private LocalDate vigenciaFin;

    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private PatientEntity paciente;

    public PolizaEntity() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroPoliza() { return numeroPoliza; }
    public void setNumeroPoliza(String numeroPoliza) { this.numeroPoliza = numeroPoliza; }
    public String getAsegurado() { return asegurado; }
    public void setAsegurado(String asegurado) { this.asegurado = asegurado; }
    public LocalDate getVigenciaInicio() { return vigenciaInicio; }
    public void setVigenciaInicio(LocalDate vigenciaInicio) { this.vigenciaInicio = vigenciaInicio; }
    public LocalDate getVigenciaFin() { return vigenciaFin; }
    public void setVigenciaFin(LocalDate vigenciaFin) { this.vigenciaFin = vigenciaFin; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public PatientEntity getPaciente() { return paciente; }
    public void setPaciente(PatientEntity paciente) { this.paciente = paciente; }
}
