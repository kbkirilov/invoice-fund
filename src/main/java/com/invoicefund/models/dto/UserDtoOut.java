package com.invoicefund.models.dto;

public class UserDtoOut {

    private String username;
    private String firstName;

    public UserDtoOut(String username, String firstName) {
        this.username = username;
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
