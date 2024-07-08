package ryanpark.spring.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ryanpark.spring.web.aggregate.club.TravelClub;
import ryanpark.spring.web.service.ClubService;
import ryanpark.spring.web.service.sdo.TravelClubCdo;
import ryanpark.spring.web.shared.NameValueList;

@RestController
@RequestMapping("/club")
public class ClubController {

    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping //localhost:8080/club
    public String register(@RequestBody TravelClubCdo travelClubCdo) {
        return clubService.registerClub(travelClubCdo);
    }

    // "/all" => "http://localhost:8080/club/all"
    @GetMapping("/all")
    public List<TravelClub> findAll() {
        return clubService.findAll();
    }

    @GetMapping("/{clubId}") //localhost:8090/club/clubId값
    public TravelClub find(@PathVariable String clubId) {
        return clubService.findClubById(clubId);
    }

    // 위의 cludid 와 여기의 name 을 구분할 수 없다.
//    @GetMapping("/{name}")
//    public List<TravelClub> findByName(@PathVariable String name) {
//        return clubService.findClubsByName(name);
//    }

    @GetMapping  //localhost:8090/club?name=JavaClub
    public List<TravelClub> findByName(@RequestParam String name) {
        System.out.println("name = " + name);
        return clubService.findClubsByName(name);
    }

    @PutMapping("/{clubId}")
    public void modify(@PathVariable String clubId, @RequestBody NameValueList nameValueList) {
        clubService.modify(clubId, nameValueList);
    }

    @DeleteMapping("/{clubId}")
    public void delete(@PathVariable String clubId) {
        clubService.remove(clubId);
    }

}
