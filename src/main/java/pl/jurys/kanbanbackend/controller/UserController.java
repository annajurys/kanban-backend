package pl.jurys.kanbanbackend.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jurys.kanbanbackend.model.User;
import pl.jurys.kanbanbackend.repository.UserRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @PostMapping("")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return this.userRepository.findUserByUserId(userId);
    }

    @PutMapping(value = "/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody User user) {
        User userToUpdate = userRepository.findUserByUserId(userId);
        if(user.getEmail()!=null) {
            userToUpdate.setEmail(user.getEmail());
        }
        if(user.getFirstName()!=null) {
            userToUpdate.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null) {
            userToUpdate.setLastName(user.getLastName());
        }
        if(user.getPassword()!=null) {
            userToUpdate.setPassword(user.getPassword());
        }
        userRepository.save(userToUpdate);
    }

    @GetMapping("/login/{email}/{password}")
    public String getLoginResponse(@PathVariable String email, @PathVariable String password) throws NotFoundException {
        if(this.userRepository.findUserByEmail(email) == null)
            throw new NotFoundException(email);
        if(this.userRepository.findUserByEmail(email).getPassword().equals(password))
            return "true";
        return "false";
    }
}
