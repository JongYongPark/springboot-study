package io.namoosori.travelclub.web.repository;


import io.namoosori.travelclub.web.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}