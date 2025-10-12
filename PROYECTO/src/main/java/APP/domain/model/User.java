package APP.domain.model;
import java.util.Date;

import APP.domain.model.enums.Role;

public class User extends Person {
    private String username;
    private String email;
    private String password;


    public User(String id, String document, String name, String phoneNumber,
               Date birthDate, String address, String gender, Role role,
               String username, String email, String password) {
        super(id, document, name, phoneNumber, birthDate, address, gender, role);
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String document, String name, String username, String email, String password, String role) {
        super(id != null ? id.toString() : null, document, name, null, null, null, null, role != null ? Role.valueOf(role) : null);
        if (username == null || username.isEmpty()) throw new IllegalArgumentException("El nombre de usuario no puede ser nulo o vacío");
        if (email == null || email.isEmpty()) throw new IllegalArgumentException("El email no puede ser nulo o vacío");
        if (password == null || password.isEmpty()) throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public Role getRole() {
        return super.getRole();
    }


    @Override
    public void setRole(Role role) {
        super.setRole(role);
    }
}
