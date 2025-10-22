
package APP.infrastructure.persistance.mapper;

import APP.domain.model.User;
import APP.infrastructure.persistance.entities.UserEntity;
public class UserMapper {
 
     public static UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setDocument(user.getDocument());
        entity.setName(user.getName());
        entity.setPhoneNumber(user.getPhoneNumber());
        entity.setBirthDate(user.getBirthDate());
        entity.setAddress(user.getAddress());
        entity.setGender(user.getGender());
        entity.setRole(user.getRole());
        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        return new User(
        entity.getId(),
        entity.getDocument(),
        entity.getName(),
        entity.getPhoneNumber(),
        entity.getBirthDate(),   
        entity.getAddress(),
        entity.getGender(),
        entity.getRole(),
        entity.getUsername(),
        entity.getEmail(),
        entity.getPassword()
    );
    }
}
