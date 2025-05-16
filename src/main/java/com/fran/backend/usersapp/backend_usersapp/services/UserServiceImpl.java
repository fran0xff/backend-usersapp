package com.fran.backend.usersapp.backend_usersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fran.backend.usersapp.backend_usersapp.models.entities.User;
import com.fran.backend.usersapp.backend_usersapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    
    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);

    }

    
    @Override
    @Transactional
    public User save(User user) {
        return repository.save(user);
    }
    
    @Override
    @Transactional(readOnly = true)
    public void remove(Long id) {
        repository.deleteById(id);
        
    }
    

}
