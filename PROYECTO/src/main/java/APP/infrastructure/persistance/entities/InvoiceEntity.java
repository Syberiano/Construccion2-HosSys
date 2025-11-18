package APP.infrastructure.persistance.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private PatientEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_medica")
    private OrdenMedicaEntity ordenMedica;

    @ManyToMany
    @JoinTable(
        name = "invoice_medicamento",
        joinColumns = @JoinColumn(name = "invoice_id"),
        inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<MedicamentoEntity> medicamentos;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(nullable = false)
    private BigDecimal total;

    private String status;

    private String policyId;
    private String insuranceCompanyName;

    public InvoiceEntity() {
        this.fecha = new Date();
        this.total = BigDecimal.ZERO;
        this.status = "PENDIENTE";
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public PatientEntity getPaciente() { return paciente; }
    public void setPaciente(PatientEntity paciente) { this.paciente = paciente; }
    public OrdenMedicaEntity getOrdenMedica() { return ordenMedica; }
    public void setOrdenMedica(OrdenMedicaEntity ordenMedica) { this.ordenMedica = ordenMedica; }
    public List<MedicamentoEntity> getMedicamentos() { return medicamentos; }
    public void setMedicamentos(List<MedicamentoEntity> medicamentos) { this.medicamentos = medicamentos; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPolicyId() { return policyId; }
    public void setPolicyId(String policyId) { this.policyId = policyId; }
    public String getInsuranceCompanyName() { return insuranceCompanyName; }
    public void setInsuranceCompanyName(String insuranceCompanyName) { this.insuranceCompanyName = insuranceCompanyName; }
}
