package com.psp.psp13.repository;

import com.psp.psp13.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
