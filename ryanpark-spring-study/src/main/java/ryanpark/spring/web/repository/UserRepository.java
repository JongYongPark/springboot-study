package ryanpark.spring.web.repository;

import java.util.List;
import java.util.Optional;

import ryanpark.spring.web.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Query(value = "select u from User1 u where first_name like :term or last_name like :term or login like :term")
    List<User> search(@Param("term") String term);
}
