package com.psp.psp13.service;

import com.psp.psp13.model.User;
import com.psp.psp13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){return (List<User>)repository.findAll();}
    public Optional<User> findUserById(Long userId){return repository.findById(userId);}

    public Long findMaxId(){
        Iterable<User> user = repository.findAll();
        Long max = 0L;
        for (User item: user){
            if (item.getUserId() > max) max = item.getUserId();
        }
        return max;
    }

    public void update(User user){repository.save(user);}

    public User add(User user){return repository.save(user);}

    public void deleteById(Long userId){repository.deleteById(userId);}

    public void delete(User user){repository.delete(user);}
}
