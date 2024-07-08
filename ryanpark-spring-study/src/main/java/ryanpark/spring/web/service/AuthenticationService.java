package ryanpark.spring.web.service;

import java.nio.CharBuffer;
import javax.transaction.Transactional;

import ryanpark.spring.web.dto.CredentialsDto;
import ryanpark.spring.web.dto.UserDto;
import ryanpark.spring.web.entitiy.User;
import ryanpark.spring.web.exception.AppException;
import ryanpark.spring.web.mapper.UserMapper;
import ryanpark.spring.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Transactional
    public UserDto authenticate(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new AppException("User1 not found", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            log.debug("User1 {} authenticated correctly", credentialsDto.getLogin());
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Login not found", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
}
