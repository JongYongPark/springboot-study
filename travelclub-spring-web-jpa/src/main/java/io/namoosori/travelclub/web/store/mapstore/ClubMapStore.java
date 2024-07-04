package io.namoosori.travelclub.web.store.mapstore;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.ClubStore;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// https://velog.io/@dani0817/Spring-Boot-%EB%A6%AC%ED%8F%AC%EC%A7%80%ED%84%B0%EB%A6%ACRepository-%EB%9E%80

//ryan : ClubJpaStore 작성 후 더이상 사용하지 않으므로 bin에서 제거한다.
//@Repository("clubStore")
public class ClubMapStore implements ClubStore {
	
	private Map<String, TravelClub> clubMap;

	public ClubMapStore() {
		this.clubMap = new LinkedHashMap<>();
	}
	
	@Override
	public String create(TravelClub club) {
		this.clubMap.put(club.getId(), club);
		return club.getId();
	}

	@Override
	public TravelClub retrieve(String clubId) {
		return clubMap.get(clubId);
	}

	@Override
	public List<TravelClub> retrieveByName(String name) {
		/* @formatter:off */  
		return clubMap.values()
				      .stream()
				      .filter( club -> club.getName().equals(name))
				      .collect(Collectors.toList());
		/* @formatter:on */
	}


	@Override
	public List<TravelClub> retrieveAll(){
		return clubMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public void update(TravelClub club) {
		clubMap.put(club.getId(), club);
	}

	@Override
	public void delete(String clubId) {
		clubMap.remove(clubId);

	}

	@Override
	public boolean exists(String clubId) {
//		return clubMap.containsKey(clubId);
		return Optional.ofNullable(clubMap.get(clubId)).isPresent();
	}

}
