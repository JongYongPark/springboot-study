package io.namoosori.travelclub.web.service;

import io.namoosori.travelclub.web.dto.UserLocationDTO;
import io.namoosori.travelclub.web.model.User;
import io.namoosori.travelclub.web.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//https://github.com/RameshMF/springboot-dto-tutorial/blob/main/src/main/java/net/javaguides/springboot/service/UserService.java
// https://www.baeldung.com/java-modelmapper
// https://velog.io/@easy_on7/JavaSpring-ModelMapper

@Service
public class UserService {

//    repository 는 spring boot data jpa를 관리한다.
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    // this can be called by the client to get user infromation using UserLocationDTO
    public List<UserLocationDTO> getAllUsersLocation(){
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

//    modelMapper 를 사용하지 않으면 2개의 DAO ( Entity ) 에서 정보를 가져와서 하나의 DTO 에 넣어줘야 한다.

//    private UserLocationDTO convertEntityToDto(User user){
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongitude(user.getLocation().getLongitude());
//        userLocationDTO.setLatitude(user.getLocation().getLatitude());
//        return userLocationDTO;
//    }

    private UserLocationDTO convertEntityToDto(User user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
        return userLocationDTO;
    }

    private User convertDtoToEntity(UserLocationDTO userLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user = new User();
        user = modelMapper.map(userLocationDTO, User.class);
        return user;
    }
}