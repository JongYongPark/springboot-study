package ryanpark.spring.web.service.logic;

import ryanpark.spring.web.aggregate.club.TravelClub;
import ryanpark.spring.web.service.ClubService;
import ryanpark.spring.web.service.sdo.TravelClubCdo;
import ryanpark.spring.web.shared.NameValueList;
import ryanpark.spring.web.store.ClubStore;
import ryanpark.spring.web.util.exception.NoSuchClubException;
import org.springframework.stereotype.Service;

import java.util.List;

//실제 service logic을 여기서 구현한다.

@Service("clubService")
public class ClubServiceLogic implements ClubService {
	//
	private ClubStore clubStore;

	// without DI
//	public ClubServiceLogic(ClubStore clubStore) {
//		//
//		this.clubStore = new ClubStore();
//	}

//	xml 에서 사용하는 방법
//	src/main/resources/applicationContext.xml 에서 DI 설정할 수 있음.
//	여기서는 constructor injection 을 사용하고 있다.
//	다른 방법으로는 setter / method injection이 있다.
	public ClubServiceLogic(ClubStore clubStore) {
		//
		this.clubStore = clubStore;
	}

	@Override
	public String registerClub(TravelClubCdo clubCdo) {
		//
		TravelClub club = new TravelClub(clubCdo.getName(), clubCdo.getIntro());
		club.checkValidation();
		String clubId = clubStore.create(club);
		return clubId;
	}

	@Override
	public TravelClub findClubById(String id) {
		return clubStore.retrieve(id);
	}

	@Override
	public List<TravelClub> findClubsByName(String name) {
		return clubStore.retrieveByName(name);
	}

	@Override
	public List<TravelClub> findAll(){
		return clubStore.retrieveAll();
	}
	
	@Override
	public void modify(String clubId, NameValueList nameValues) {
		TravelClub foundedClub = clubStore.retrieve(clubId);
		if(foundedClub == null) {
			throw new NoSuchClubException("No such club with id : " + clubId);
		}
		foundedClub.modifyValues(nameValues);
		clubStore.update(foundedClub);
	}
	
	@Override
	public void remove(String clubId) {
		if(!clubStore.exists(clubId) ) {
			throw new NoSuchClubException("No such club with id : " + clubId);
		}
		clubStore.delete(clubId);
	}

}
