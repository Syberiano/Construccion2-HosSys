package APP.domain.ports;

import APP.domain.model.User;
import java.util.List;

public interface UserPort {

    User save(User user) throws Exception;

    User findById(String id) throws Exception;

    User findByDocument(String document) throws Exception;

    User findByUserName(String username) throws Exception;

    User findByEmail(String email) throws Exception;

    boolean existsByUserName(String username) throws Exception;

    boolean existsByDocument(String document) throws Exception;

    boolean deleteById(String id) throws Exception;

    List<User> findAll() throws Exception;
}