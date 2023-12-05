package com.project.elearning.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.elearning.model.User;
import com.project.elearning.repository.UserRepo;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userrepo;

    @Override
    public List<User> getAllUser() {
        return userrepo.findAll();
    }

    @Override
    public User createUser(User create) {
        return userrepo.save(create);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userrepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(Long id, User updatedUser) {
        if (!userrepo.existsById(id)) {
            return Optional.empty();
        }

        updatedUser.setId(id);
        return Optional.of(userrepo.save(updatedUser));
    }

    @Override
    public boolean deleteUser(Long id) {
        if (!userrepo.existsById(id)) {
            return false;
        }
        userrepo.deleteById(id);
        return true;
    }

    @Override
    public boolean existsById(Long id){
        return true;
    }

     @Override
    public void deleteById(Long id){
      
    }


}
