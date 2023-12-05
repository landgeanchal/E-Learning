package com.project.elearning.services;

import java.util.List;
import java.util.Optional;
import com.project.elearning.model.User;

public interface UserService {

    public List<User> getAllUser();

    public Optional<User> getUserById(Long id);

    public User createUser(User create);

    public Optional<User> updateUser(Long id, User updatedUser);

    public boolean deleteUser(Long id);

    public boolean existsById(Long id);

    public void deleteById(Long id);

   
}
