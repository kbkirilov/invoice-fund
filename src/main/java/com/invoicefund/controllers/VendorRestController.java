package com.invoicefund.controllers;

import com.invoicefund.helpers.ModelMapper;
import com.invoicefund.services.interfaces.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor-portal/vendors")
public class VendorRestController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public VendorRestController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }
}
