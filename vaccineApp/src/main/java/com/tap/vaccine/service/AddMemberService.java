package com.tap.vaccine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.AddMemberDAO;
import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class AddMemberService {
	
	private AddMemberDAO memberdao;
	private LoginDAO logindao;
	
	@Autowired
	public AddMemberService(AddMemberDAO memberdao,LoginDAO logindao) {
		this.memberdao = memberdao;
		this.logindao=logindao;
	}

	public boolean ValidateData(String memberName, String membergender, String memberDOB, String memberidProof,
			String idProof, String vaccineType, int dose,String refemail) {
		boolean flag=false;
		if(memberName!=null && !memberName.isBlank() && !memberName.isEmpty()) {
			flag=true;
		}else {
			return false;
		}
		if(membergender!=null && !membergender.isBlank() && !membergender.isEmpty()) {
			flag=true;
		}else {
			return false;
		}
		if(memberDOB!=null && !memberDOB.isBlank() && !memberDOB.isEmpty()) {
			flag=true;
		}else {
			return false;
		}
		if(memberidProof!=null && !memberidProof.isBlank() && !memberidProof.isEmpty()) {
			flag=true;
		}else {
			return false;
		}
		if(idProof!=null && !idProof.isBlank() && !idProof.isEmpty()) {
			flag=true;
		}else {
			return false;
		}
		if(vaccineType!=null && !vaccineType.isBlank() && !vaccineType.isEmpty()) {
			flag=true;
		}else {
			return false;
		}
		if(dose>0 && dose<4) {
			flag=true;
		}else {
			return false;
		}
		if(refemail!=null && !refemail.isBlank() && !refemail.isEmpty()) {
			flag=true;
		}else {
			return false;
		}
		return flag;
	}

	public boolean saveMember(String memberName, String membergender, String memberDOB, String memberidProof,
			String idProofno, String vaccineType, int dose,String refemail) {
		System.out.println("service method");
		MemberEntity entity=new MemberEntity(memberName,membergender,memberDOB,memberidProof,idProofno,vaccineType,dose,refemail);
		RegisterEntity entity1 = logindao.getRegisterEntityByEmail(refemail);
		int membercount=entity1.getMemberCount();
		if(membercount>=4) {
			return false;
		}else {
			int i=memberdao.updateMemberCount(refemail,membercount);
			return memberdao.saveMember(entity);
		}
	}

	public List<MemberEntity> getMemberData(String email) {
		return memberdao.getMemberData(email);
	}

	public MemberEntity getMemberData(int id) {
		return memberdao.getMemberData(id);
	}

	public boolean editMember(int memberid,String memberName, String membergender, String memberDOB, String memberidProof,
			String idProofno, String vaccineType, int dose,String refemail) {
		System.out.println("edit service");
		MemberEntity entity=new MemberEntity(memberid,memberName,membergender,memberDOB,memberidProof,idProofno,vaccineType,dose,refemail);
		return memberdao.editMember(entity);
	}

	public boolean deleteMember(MemberEntity entity) {
		
		return memberdao.deleteMember(entity);
	}

	public void updateRegisterEntityMemberCount(String refemail) {
		RegisterEntity entity=logindao.getRegisterEntityByEmail(refemail);
		int memberCount=entity.getMemberCount();
		int i=memberdao.decreseMemberCount(refemail,memberCount);
		
	}


}
