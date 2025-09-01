package APP.domain.model;
import APP.domain.model.emuns.Role;

public class User extends Person {
    private String username;
    private String email;
    private String password;
    private Role role;

   
    public User(Long id, String document, String name,
                String username, String email, String password, String role) {
        super(id, document, name); 
        this.username = username;
        this.email = email;
        this.password = password;
        this.Role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(String role) {
        this.Role = role;
    }
}
