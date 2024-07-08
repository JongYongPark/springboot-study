package ryanpark.spring.web.service;

import ryanpark.spring.web.dto.User1LocationDTO;
import ryanpark.spring.web.model.User1;
import ryanpark.spring.web.repository.User1Repository;
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
public class User1Service {

//    repository 는 spring boot data jpa를 관리한다.
    @Autowired
    private User1Repository user1Repository;

    @Autowired
    private ModelMapper modelMapper;

    // this can be called by the client to get user infromation using User1LocationDTO
    public List<User1LocationDTO> getAllUsersLocation(){
        return user1Repository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

//    modelMapper 를 사용하지 않으면 2개의 DAO ( Entity ) 에서 정보를 가져와서 하나의 DTO 에 넣어줘야 한다.

//    private User1LocationDTO convertEntityToDto(User1 user){
//        User1LocationDTO userLocationDTO = new User1LocationDTO();
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongitude(user.getLocation().getLongitude());
//        userLocationDTO.setLatitude(user.getLocation().getLatitude());
//        return userLocationDTO;
//    }

    private User1LocationDTO convertEntityToDto(User1 user1){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User1LocationDTO user1LocationDTO = new User1LocationDTO();
        user1LocationDTO = modelMapper.map(user1, User1LocationDTO.class);
        return user1LocationDTO;
    }

    private User1 convertDtoToEntity(User1LocationDTO user1LocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User1 user1 = new User1();
        user1 = modelMapper.map(user1LocationDTO, User1.class);
        return user1;
    }
}