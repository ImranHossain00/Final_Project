package com.sir.tech.bd.service;

import com.sir.tech.bd.domain.User;
import com.sir.tech.bd.dto.UserSignupDTO;
import com.sir.tech.bd.repository.UserCustomerRepo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserCustomerServiceImpl implements UserCustomerService{
    // For fetching data from database
    UserCustomerRepo customerRepo;

    public UserCustomerServiceImpl(UserCustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    // logic to save as User domain in our database
    @Override
    public void saveUser(UserSignupDTO userSignupDTO) {
        User user = copy(userSignupDTO);
        customerRepo.save(user);
    }

    @Override
    public boolean isUserNameUnique(String username) {
        return true;
    }

    @Override
    public boolean isEmailUnique(String email) {
        return true;
    }

    // Copying from userDTO to User.
    private User copy(UserSignupDTO userSignupDTO) {
        User user = new User();

        user.setUsername(userSignupDTO.getUsername());
        user.setPassword(encryptPassword(userSignupDTO.getPassword()));
        user.setEmail(userSignupDTO.getEmail());
        user.setFirstame(userSignupDTO.getFirstName());
        user.setLastName(userSignupDTO.getLastName());
        user.setVersion(user.getVersion() + 1);

        return user;
    }

    // Password encryption
    private String encryptPassword(String password) {
        try {
            var digest = MessageDigest.getInstance("SHA-256");
            var bytes = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8)
            );
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to encrypt password", e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
