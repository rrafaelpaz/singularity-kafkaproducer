package com.singularity.kafkaproducer.api;


import com.singularity.kafkaproducer.model.User;
import com.singularity.kafkaproducer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String produceMessage(@NotNull @Valid @RequestBody User user){
        return userService.produceMessage(user);
    }

}
