package ryanpark.spring.web.service.logic;

import ryanpark.spring.web.aggregate.club.CommunityMember;
import ryanpark.spring.web.service.MemberService;
import ryanpark.spring.web.service.sdo.MemberCdo;
import ryanpark.spring.web.shared.NameValueList;
import ryanpark.spring.web.store.MemberStore;
import ryanpark.spring.web.util.exception.MemberDuplicationException;
import ryanpark.spring.web.util.exception.NoSuchMemberException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceLogic implements MemberService {
	//
	private MemberStore memberStore;

//	MemberStore 를 implement 한것은 MemberMapStore 밖에 없으므로 MemberMapStore 를 inject 한다.
//	여려 interface 가 구현되어 있을때는 qualifier를 이용해야 한다.
	public MemberServiceLogic(MemberStore memberStore) {
		//
		this.memberStore = memberStore;
	}


	@Override
	public String registerMember(MemberCdo newMemberCdo) {
		//
		String email = newMemberCdo.getEmail();
		CommunityMember member = memberStore.retrieveByEmail(email);

		if (member != null) {
			throw new MemberDuplicationException("Member already exists with email: " + member.getEmail());
		}

		member = new CommunityMember(
				newMemberCdo.getEmail(),
				newMemberCdo.getName(),
				newMemberCdo.getPhoneNumber()
		);
		member.setNickName(newMemberCdo.getNickName());
		member.setBirthDay(newMemberCdo.getBirthDay());

		member.checkValidation();

		memberStore.create(member);

		return member.getId();
	}

	@Override
	public CommunityMember findMemberById(String memberId) {
		return memberStore.retrieve(memberId);
	}

	@Override
	public CommunityMember findMemberByEmail(String memberEmail) {
		return memberStore.retrieveByEmail(memberEmail);
	}

	@Override
	public List<CommunityMember> findMembersByName(String name) {
		return memberStore.retrieveByName(name);
	}

	@Override
	public void modifyMember(String memberId, NameValueList nameValueList) {
		CommunityMember targetMember = memberStore.retrieve(memberId);
		if(targetMember == null) {
			throw new NoSuchMemberException("No such member with id : " + memberId);
		}
		targetMember.modifyValues(nameValueList);
		memberStore.update(targetMember);
	}

	@Override
	public void removeMember(String memberId) {
		if(!memberStore.exists(memberId)) {
			throw new NoSuchMemberException("No such member with id : " + memberId);
		}
		memberStore.delete(memberId);
	}

}
