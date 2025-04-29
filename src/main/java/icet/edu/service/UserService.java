package icet.edu.service;

import icet.edu.dto.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserById(Long id);

    List<User> searchByUsername(String username);
}
