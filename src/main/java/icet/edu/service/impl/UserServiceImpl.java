package icet.edu.service.impl;

import icet.edu.dto.User;
import icet.edu.entity.UserEntity;
import icet.edu.repository.UserRepository;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

        private final UserRepository repository;
        private final ModelMapper mapper;

        @Override
        public void addUser(User user) {
            repository.save(mapper.map(user, UserEntity.class));
        }

        @Override
        public List<User> getAllUsers() {
            List<UserEntity> all = repository.findAll();
            return all.stream()
                    .map(entity -> mapper.map(entity, User.class))
                    .toList();
        }

        @Override
        public void deleteUser(Long id) {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new RuntimeException("User with ID " + id + " not found");
            }
        }

        @Override
        public void updateUser(User user) {
            repository.save(mapper.map(user, UserEntity.class));
        }

        @Override
        public User getUserById(Long id) {
            UserEntity userEntity = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found"));
            return mapper.map(userEntity, User.class);
        }

        @Override
        public List<User> searchByUsername(String username) {
            List<UserEntity> entities = repository.findByUsername(username);
            return entities.stream()
                    .map(entity -> mapper.map(entity, User.class))
                    .toList();
        }
    }

