package ryanpark.spring.web.repository;


import ryanpark.spring.web.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}