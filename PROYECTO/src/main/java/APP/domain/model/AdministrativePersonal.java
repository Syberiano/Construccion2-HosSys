package APP.domain.model;

import APP.domain.model.emuns.Role;

import java.util.Date;

public class AdministrativePersonal extends Person{
    public AdministrativePersonal(String id, String document, String name, String phoneNumber, Date birthDate, String address, String gender, Role role) {
        super(id, document, name, phoneNumber, birthDate, address, gender, role);
    }
}
