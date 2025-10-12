package APP.domain.model;
import java.util.Date;

import APP.domain.model.enums.Role;

public class Person {
    private String id;
    private String document;
    private String name;
    private String phoneNumber;
    private Date birthDate;
    private String address;
    private String gender;
    private Role role;

    public Person(String id, String document, String name, String phoneNumber, Date birthDate, String address, String gender, Role role) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("El id no puede ser nulo o vacío");
        if (document == null || document.isEmpty()) throw new IllegalArgumentException("El documento no puede ser nulo o vacío");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        this.id = id;
        this.document = document;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
        this.role = role;
    }

    public Person() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}




