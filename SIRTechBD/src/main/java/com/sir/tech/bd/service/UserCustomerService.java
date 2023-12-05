package com.sir.tech.bd.service;

import com.sir.tech.bd.dto.UserSignupDTO;

public interface UserCustomerService {

    void saveUser(UserSignupDTO userSignupDTO);
    boolean isUserNameUnique(String username);

    boolean isEmailUnique(String email);


}
