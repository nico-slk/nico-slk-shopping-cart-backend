package it.factor.shopping_cart_backend.controller;

import it.factor.shopping_cart_backend.dto.UserDTO;
import it.factor.shopping_cart_backend.model.User;
import it.factor.shopping_cart_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/prod")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUser(name));
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/prod")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

}
