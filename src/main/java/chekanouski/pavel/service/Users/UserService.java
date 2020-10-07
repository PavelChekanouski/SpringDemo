package chekanouski.pavel.service.Users;

import chekanouski.pavel.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);
}
