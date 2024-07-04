package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.dto.UserLocationDTO;
import io.namoosori.travelclub.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

//    controller use service here we use DTO
    @Autowired
    private UserService userService;

    @GetMapping("/users-location")
    public List<UserLocationDTO> getAllUsersLocation(){
        return userService.getAllUsersLocation();
    }
}