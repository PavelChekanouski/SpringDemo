package chekanouski.pavel.controller;

import chekanouski.pavel.entity.User;
import chekanouski.pavel.service.Users.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userServiceImpl.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam Long id){
        return new ResponseEntity<>(userServiceImpl.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public void saveUser( @RequestBody User user){
        userServiceImpl.saveUser(user);
    }

    @PostMapping("/updateUserById")
    public void updateUser(@RequestBody User user){
        userServiceImpl.updateUser(user);
    }

    @PostMapping("/deleteUserById")
    public void deleteUserById(@RequestBody Long id){
        userServiceImpl.deleteUserById(id);
    }
}
