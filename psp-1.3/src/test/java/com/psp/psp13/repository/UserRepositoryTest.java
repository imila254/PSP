package com.psp.psp13.repository;

import com.psp.psp13.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void save_Test(){
        User user = new User(1L, "Vardenis","Pavardenis","861111111","email@email.com","Pieniu g. 5","Password@");
        repository.save(user);

        Optional<User> userById = repository.findById(1L);
        assertNotNull(userById);
    }

    @Test
    public void findAll_Test(){
        User user = new User(1L, "Vardenis","Pavardenis","861111111","email@email.com","Pieniu g. 5","Password@");
        repository.save(user);

        Iterable<User> users = repository.findAll();
        assertNotNull(users);

        List<User> result = new ArrayList<>();
        users.forEach(result::add);

        assertEquals(1, result.size());
    }

    @Test
    public void delete_Test(){
        User user = new User(1L, "Vardenis","Pavardenis","861111111","email@email.com","Pieniu g. 5","Password@");
        repository.save(user);
        repository.deleteById(1L);

        Iterable<User> users = repository.findAll();
        assertNotNull(user);

        List<User> result = new ArrayList<>();
        users.forEach(result::add);

        assertEquals(0, result.size());
    }

}
