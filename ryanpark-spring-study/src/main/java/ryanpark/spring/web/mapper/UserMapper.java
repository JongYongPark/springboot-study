package ryanpark.spring.web.mapper;

import java.util.List;

import ryanpark.spring.web.dto.ImageDto;
import ryanpark.spring.web.dto.ProfileDto;
import ryanpark.spring.web.dto.SignUpDto;
import ryanpark.spring.web.dto.UserDto;
import ryanpark.spring.web.dto.UserSummaryDto;
import ryanpark.spring.web.entitiy.Image;
import ryanpark.spring.web.entitiy.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    UserSummaryDto toUserSummary(User user);

    List<UserSummaryDto> toUserSummaryDtos(List<User> users);

    @Mapping(target = "userDto.id", source = "id")
    @Mapping(target = "userDto.firstName", source = "firstName")
    @Mapping(target = "userDto.lastName", source = "lastName")
    ProfileDto userToProfileDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

    @Mapping(target = "userDto", source = "user")
    ImageDto imageToImageDto(Image image);

    List<ImageDto> imagesToImageDtos(List<Image> images);
}
