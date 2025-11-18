package APP.domain.model;
import jakarta.persistence.Embeddable;

@Embeddable

public class EmergencyContact {
    private String name;
    private String relationship;
    private String phoneNumber;

    public EmergencyContact() {
    }

    public EmergencyContact(String name, String relationship, String phoneNumber) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        if (relationship == null || relationship.isEmpty()) throw new IllegalArgumentException("La relación no puede ser nula o vacía");
        if (phoneNumber == null || phoneNumber.isEmpty()) throw new IllegalArgumentException("El teléfono no puede ser nulo o vacío");
        this.name = name;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
