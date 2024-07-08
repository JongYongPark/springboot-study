package ryanpark.spring.web.repository;

import ryanpark.spring.web.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;

//스프링데이타에게 entity를 넘겨서 알라서 처리하도록 한다.
public interface User1Repository extends JpaRepository<User1, Long> {
}