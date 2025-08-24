package APP.domain.model;

public class Patient {
    private Long id;
    private String name;
    private int age;
    private String identification;
    private EmergencyContact emergencyContact;
    private HealthInsurance healthInsurance;

    public Patient() {}

    public Patient(Long id, String name, int age, String identification,
                   EmergencyContact emergencyContact, HealthInsurance healthInsurance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.identification = identification;
        this.emergencyContact = emergencyContact;
        this.healthInsurance = healthInsurance;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getIdentification() { return identification; }
    public void setIdentification(String identification) { this.identification = identification; }

    public EmergencyContact getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(EmergencyContact emergencyContact) { this.emergencyContact = emergencyContact; }

    public HealthInsurance getHealthInsurance() { return healthInsurance; }
    public void setHealthInsurance(HealthInsurance healthInsurance) { this.healthInsurance = healthInsurance; }
}
