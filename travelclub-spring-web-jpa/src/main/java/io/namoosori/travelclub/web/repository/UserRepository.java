package io.namoosori.travelclub.web.repository;

import io.namoosori.travelclub.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//스프링데이타에게 entity를 넘겨서 알라서 처리하도록 한다.
public interface UserRepository extends JpaRepository<User, Long> {
}