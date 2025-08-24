package APP.domain.services;

import APP.domain.model.User;

public class CreateUser {

    public User createUser(String id, String name, String email, String role) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setRole(role);
        return user;
    }
}
