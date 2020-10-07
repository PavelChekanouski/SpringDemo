package chekanouski.pavel.service.Users;

import chekanouski.pavel.entity.User;
import chekanouski.pavel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.updateUserById(user.getId(), user.getUsername(), user.getPassword());
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
