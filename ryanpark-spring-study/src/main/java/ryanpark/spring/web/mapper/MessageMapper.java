package ryanpark.spring.web.mapper;

import java.util.List;

import ryanpark.spring.web.dto.MessageDto;
import ryanpark.spring.web.entitiy.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
    uses = {UserMapper.class})
public interface MessageMapper {

    List<MessageDto> messagesToMessageDtos(List<Message> messages);

    @Mapping(target = "userDto", source = "user")
    MessageDto messageToMessageDto(Message message);

    Message messageDtoToMessage(MessageDto messageDto);
}
