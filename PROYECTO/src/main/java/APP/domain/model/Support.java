package APP.domain.model;

import APP.domain.model.emuns.Role;

import java.util.Date;

public class Support extends Person{

    public Support(String id, String document, String name, String phoneNumber, Date birthDate, String address, String gender, Role role) {
        super(id, document, name, phoneNumber, birthDate, address, gender, role);
    }
}
