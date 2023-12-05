package com.sir.tech.bd.repository;

import com.sir.tech.bd.domain.User;

import java.util.List;

public interface UserCustomerRepo {
    void save(User user);

    List<User> findAllUsers();


}
