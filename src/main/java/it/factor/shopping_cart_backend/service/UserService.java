package it.factor.shopping_cart_backend.service;

import it.factor.shopping_cart_backend.dto.UserDTO;
import it.factor.shopping_cart_backend.model.User;
import it.factor.shopping_cart_backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(String name) {
        User user = userRepository.findByUsername(name)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        if (user.getTotalSpendMonth() > 10000) {
            user.setVip(true);
        }

        userRepository.save(user);
        return user;
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setVip(userDTO.isVip());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
