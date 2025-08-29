package APP.domain.ports;

import APP.domain.model.User;

public interface UserPort {

    User findByDocument(User user);
    User findByUserName(User user);
    User deleteById(User User);

    void save(User user);
}