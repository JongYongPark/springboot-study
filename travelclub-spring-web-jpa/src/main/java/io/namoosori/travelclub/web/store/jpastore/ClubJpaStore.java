package io.namoosori.travelclub.web.store.jpastore;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.ClubStore;
import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import io.namoosori.travelclub.web.store.jpastore.repository.ClubRepository;
import io.namoosori.travelclub.web.util.exception.NoSuchClubException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//ryan : entity를 만든 것을 jpa 가 아닌 spring data에게 맞긴다.
//https://velog.io/@rockwellvinca/Spring-Entitiy-DTO-DAO%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80
//https://velog.velcdn.com/images/rockwellvinca/post/df99280a-d940-44a1-b629-59d9dec2635a/image.png

//TravelClubCdo - DTO - from user to database
//TravelClub - DTO - from database to user
//TravelClub - DTO

//ClubRepository - repository - DAO
//  TravelClub 을 받아서 ( DTO )
//  TravelClubJpo 를 update
//TravelClubJpo - Entity - 실제 database 에 저장할 table과 1:1 매핑

// repository ( springboot data ) call jpa persistance api which run without springboot data.

//@Repository("clubStore")
@Repository
public class ClubJpaStore implements ClubStore {
    private ClubRepository clubRepository;

//    ryan : spring data jpa 에서 주입해 준다.
    public ClubJpaStore(ClubRepository clubRepository){
        this.clubRepository = clubRepository;
    }

    @Override
    public String create(TravelClub club) {
        clubRepository.save(new TravelClubJpo(club));
        return club.getId();
    }

//    clubId 즉 id column을 가지고 data를 가져온다.
    @Override
    public TravelClub retrieve(String clubId) {
        Optional<TravelClubJpo> clubJpo = clubRepository.findById(clubId);
        if(!clubJpo.isPresent()){
            throw new NoSuchClubException(String.format("TravelClub(%s) is not found", clubId));
        }
        return clubJpo.get().toDomain();
    }


    @Override
    public List<TravelClub> retrieveAll() {
        List<TravelClubJpo> clubJpos = clubRepository.findAll();
//        return clubJpos.stream().map(clubJpo -> clubJpos.toDomain()).collect(Collectors.toList());
        return clubJpos.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());
    }

    // ryan ; jpo is dto.

    @Override
    public List<TravelClub> retrieveByName(String name) {
        List<TravelClubJpo> clubJpos = clubRepository.findAllByName(name);
        return clubJpos.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());
    }

//    clubRepository.save 는 create 뿐만 아니라 update까지 지원한다. 기존 id가 있는 경우 update
//    save 는  jpa persistance 하위 함수를 가지고 처리한다.
    @Override
    public void update(TravelClub club) {
        clubRepository.save(new TravelClubJpo());
    }

    @Override
    public void delete(String clubId) {
        clubRepository.deleteById(clubId);

    }

    @Override
    public boolean exists(String clubId) {
        return clubRepository.existsById(clubId);
    }
}
