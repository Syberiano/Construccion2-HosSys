package APP.domain.services;


import APP.domain.model.User;


public class CreateUser {

    public User execute(Long id, String document, String name, String username, String email, String password, String role) {
       
     
      
        User user = new User();
        user.setId(id);
        user.setDocument(document);
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
   if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("El email no es válido");
        }

        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }

        return user;
    }
}
