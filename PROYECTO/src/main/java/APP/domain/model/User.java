package APP.domain.model;
import APP.domain.model.emuns.Role;
import java.util.Date;

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
        super();
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
