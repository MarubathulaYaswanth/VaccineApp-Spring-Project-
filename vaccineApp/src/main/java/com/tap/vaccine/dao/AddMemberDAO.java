package com.tap.vaccine.dao;

import java.util.List;

import com.tap.vaccine.entity.MemberEntity;

public interface AddMemberDAO {

	boolean saveMember(MemberEntity entity);

	List<MemberEntity> getMemberData(String email);

	int updateMemberCount(String refemail,int membercount);

	MemberEntity getMemberData(int id);

	boolean editMember(MemberEntity entity);

	boolean deleteMember(MemberEntity entity);

	int decreseMemberCount(String refemail, int memberCount);

}
