package com.invoicefund.controllers;

import com.invoicefund.exceptions.EntityNotFoundException;
import com.invoicefund.helpers.ModelMapper;
import com.invoicefund.models.User;
import com.invoicefund.models.dto.UserDtoOut;
import com.invoicefund.services.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRestController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public UserDtoOut getUserById(@PathVariable int id) {
        try {
            User user = userService.getUserById(id);
            return modelMapper.fromUserToUserDtoOut(user);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
