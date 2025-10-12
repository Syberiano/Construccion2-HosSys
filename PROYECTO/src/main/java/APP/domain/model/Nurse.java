package APP.domain.model;
import java.util.Date;

import APP.domain.model.enums.Role;

public class Nurse extends Person {
    public Nurse(String id, String document, String name, String phoneNumber, Date birthDate, String address, String gender, Role role) {
        super(id, document, name, phoneNumber, birthDate, address, gender, role);
    }
}
