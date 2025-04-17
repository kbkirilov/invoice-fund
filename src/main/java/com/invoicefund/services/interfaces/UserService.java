package com.invoicefund.services.interfaces;

import com.invoicefund.models.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);

    List<User> getAllUsers();
}
