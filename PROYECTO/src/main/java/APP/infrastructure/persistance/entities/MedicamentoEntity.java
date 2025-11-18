package APP.infrastructure.persistance.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicamentos")
public class MedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nombre;

    private Integer cantidadDisponible;
    private String dosis;

    private LocalDate fechaVencimiento;

    private Double precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor_prescriptor")
    private DoctorEntity doctorPrescriptor;

    public MedicamentoEntity(){}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(Integer cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public String getDosis() { return dosis; }
    public void setDosis(String dosis) { this.dosis = dosis; }
    public DoctorEntity getDoctorPrescriptor() { return doctorPrescriptor; }
    public void setDoctorPrescriptor(DoctorEntity doctorPrescriptor) { this.doctorPrescriptor = doctorPrescriptor; }
}
