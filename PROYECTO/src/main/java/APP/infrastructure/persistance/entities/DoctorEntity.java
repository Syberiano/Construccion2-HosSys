
package APP.infrastructure.persistance.entities;

import jakarta.persistence.*;
import java.util.*;
import APP.domain.model.enums.Role;
import APP.domain.model.Person;
@Entity
@Table(name = "doctors")
public class DoctorEntity extends Person{
    
      @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false)
    private String name;

    private String phoneNumber;
    private String address;
    private String gender;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    
    public DoctorEntity() {}

    
    public DoctorEntity(String id, String document, String name, String phoneNumber,
                        String address, String gender, Date birthDate, Role role) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.role = role;
    }

    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDocument() { return document; }
    public void setDocument(String document) { this.document = document; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    
    
}
