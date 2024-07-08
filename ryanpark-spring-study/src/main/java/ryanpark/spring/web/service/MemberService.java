package ryanpark.spring.web.service;

import ryanpark.spring.web.aggregate.club.CommunityMember;
import ryanpark.spring.web.service.sdo.MemberCdo;
import ryanpark.spring.web.shared.NameValueList;

import java.util.List;

public interface MemberService {
	//
	String registerMember(MemberCdo member);
	CommunityMember findMemberById(String memberId);
	CommunityMember findMemberByEmail(String memberEmail);
	List<CommunityMember> findMembersByName(String name);
	void modifyMember(String memberId, NameValueList member);
	void removeMember(String memberId);
}