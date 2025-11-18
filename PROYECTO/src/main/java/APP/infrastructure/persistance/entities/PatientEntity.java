
package APP.infrastructure.persistance.entities;

import APP.domain.model.EmergencyContact;
import APP.domain.model.HealthInsurance;
import jakarta.persistence.*;
import java.util.Date;
import APP.domain.model.enums.Role;

@Entity
@Table(name = "patients")

public class PatientEntity {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String document;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String gender;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "emergency_contact_name")),
            @AttributeOverride(name = "relationship", column = @Column(name = "emergency_contact_relationship")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "emergency_contact_phone"))
    })
    private EmergencyContact emergencyContact;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "insuranceId", column = @Column(name = "insurance_id")),
            @AttributeOverride(name = "providerName", column = @Column(name = "insurance_provider_name")),
            @AttributeOverride(name = "policyNumber", column = @Column(name = "insurance_policy_number")),
            @AttributeOverride(name = "coverageDetails", column = @Column(name = "insurance_coverage_details"))
    })
    private HealthInsurance healthInsurance;
    @Column
    private Role role;

    public PatientEntity() {}

    public PatientEntity(String name, String document, Date birthDate, String address, String phoneNumber, String gender) {
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
    
}
