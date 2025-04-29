package icet.edu.controller;


import icet.edu.dto.User;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/user")
public class UserController {


    final UserService service;

    @GetMapping("/get-All")
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        service.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteUser(Long.valueOf(id));
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }

    @GetMapping("/searchByUsername/{username}")
    public List<User> searchByUsername(@PathVariable String username) {
        return service.searchByUsername(username);
    }

    @GetMapping("/searchById/{id}")
    public User searchById(@PathVariable Integer id) {
        return service.getUserById(Long.valueOf(id));
    }

}
