package APP.domain.ports;

import APP.domain.model.User;

public interface UserPort {
    void save(User user);
    User findById(Long id);
}
