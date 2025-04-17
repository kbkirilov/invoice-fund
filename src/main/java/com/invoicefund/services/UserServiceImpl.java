package com.invoicefund.services;

import com.invoicefund.exceptions.EntityNotFoundException;
import com.invoicefund.models.User;
import com.invoicefund.repositories.UserRepository;
import com.invoicefund.services.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.invoicefund.helpers.Constants.TYPE_USER;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getUserById(int id) {
        return userRepository
                .getUserById(id)
                .orElseThrow(()-> new EntityNotFoundException(TYPE_USER, id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
