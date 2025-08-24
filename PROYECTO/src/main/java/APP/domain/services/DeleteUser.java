package APP.domain.services;

import APP.domain.ports.DeleteUserPort;

public class DeleteUser {

    private final DeleteUserPort deleteUserPort;

    public DeleteUser(DeleteUserPort deleteUserPort) {
        this.deleteUserPort = deleteUserPort;
    }

    public void execute(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        deleteUserPort.deleteById(id);
    }
}
