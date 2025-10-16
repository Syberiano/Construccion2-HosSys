
package APP.domain.services;

import APP.domain.model.User;
public class UpdateUser {
    
    public void update(User user) throws Exception {
        if (user == null || user.getId() == null) {
            throw new Exception("Datos de usuario invalidos");
        }
        System.out.println("El usuario " + user.getName() + " fue actualizado correctamente.");
    }
}
