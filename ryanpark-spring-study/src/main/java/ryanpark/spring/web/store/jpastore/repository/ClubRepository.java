package ryanpark.spring.web.store.jpastore.repository;

import ryanpark.spring.web.store.jpastore.jpo.TravelClubJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//ryan : 이 interface 가 spring data jpa 를 사용하기 위한 것이다.
//String 은 id 의 type 이다

public interface ClubRepository extends JpaRepository<TravelClubJpo, String> {
//    새로운 interface를 만든다.
    List<TravelClubJpo> findAllByName(String name);

}
