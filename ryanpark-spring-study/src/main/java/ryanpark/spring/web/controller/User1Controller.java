package ryanpark.spring.web.controller;

import ryanpark.spring.web.dto.User1LocationDTO;
import ryanpark.spring.web.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class User1Controller {

//    controller use service here we use DTO
    @Autowired
    private User1Service user1Service;

    @GetMapping("/users-location")
    public List<User1LocationDTO> getAllUsersLocation(){
        return user1Service.getAllUsersLocation();
    }
}