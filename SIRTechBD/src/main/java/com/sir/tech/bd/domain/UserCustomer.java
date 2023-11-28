package com.sir.tech.bd.domain;

public class UserCustomer extends Domain{
    private String username;
    private String password;
    private String fullName;
    private String lastName;
    private Long contactAddressId;
    private String email;
    private final Integer isAdmin = 0;

    public UserCustomer() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getContactAddressId() {
        return contactAddressId;
    }

    public void setContactAddressId(Long contactAddressId) {
        this.contactAddressId = contactAddressId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }
}
