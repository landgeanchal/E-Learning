package com.project.elearning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.elearning.model.User;
import com.project.elearning.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("api/e_learning/user")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUserDetails(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAlluserDetail() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userService.getUserById(id);
        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> updated = userService.updateUser(id, updatedUser);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // @DeleteMapping("/delete/{userId}")
    // public ResponseEntity<?> deleteUser(@RequestBody User user) {
    // // Perform validation or additional checks if needed
    // // For simplicity, assuming user has an ID field
    // if (user.getId() == null || !userService.existsById(user.getId())) {
    // return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    // }

    // userService.deleteById(user.getId());
    // return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    // }

    @DeleteMapping("/delete/{user}")
    public ResponseEntity<String> deleteUser(@PathVariable Long user) {
        // Check if user with the given ID exists
        if (!userService.existsById(user)) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        // Delete the user
        userService.deleteById(user);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

}
