package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_table")
public class MemberEntity {
	
	@Id
	@Column(name="MEMBER_ID")
	private int memberId;
	
	@Column(name="MEMBER_NAME")
	private String memberName;
	
	@Column(name="MEMBER_GENDER")
	private String memberGender;
	
	@Column(name="MEMBER_DOB")
	private String memberDob;
	
	@Column(name="MEMBER_IDPROOF")
	private String memberIdProof;
	
	@Column(name="ID_PROOF_NO")
	private String idProofNo;
	
	@Column(name="VACCINE_TYPE")
	private String vaccineType;
	
	@Column(name="DOSE")
	private int dose;
	
	@Column(name="REF_EMAIL")
	private String refEmail;
	
	
	
	public MemberEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public MemberEntity(int memberId, String memberName, String memberGender, String memberDob, String memberIdProof,
			String idProofNo, String vaccineType, int dose,String refEmail) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberDob = memberDob;
		this.memberIdProof = memberIdProof;
		this.idProofNo = idProofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.refEmail=refEmail;
	}



	public MemberEntity(String memberName, String memberGender, String memberDob, String memberIdProof,
			String idProofNo, String vaccineType, int dose,String refEmail) {
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberDob = memberDob;
		this.memberIdProof = memberIdProof;
		this.idProofNo = idProofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.refEmail=refEmail;
	}



	public MemberEntity(int memberId, String memberName, String memberGender, String memberDob, String memberIdProof,
			String idProofNo, String vaccineType, int dose) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberDob = memberDob;
		this.memberIdProof = memberIdProof;
		this.idProofNo = idProofNo;
		this.vaccineType = vaccineType;
		this.dose = dose;
	}



	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberDob() {
		return memberDob;
	}

	public void setMemberDob(String memberDob) {
		this.memberDob = memberDob;
	}

	public String getMemberIdProof() {
		return memberIdProof;
	}

	public void setMemberIdProof(String memberIdProof) {
		this.memberIdProof = memberIdProof;
	}
	

	public String getIdProofNo() {
		return idProofNo;
	}


	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}



	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	public String getRefEmail() {
		return refEmail;
	}

	public void setRefEmail(String refEmail) {
		this.refEmail = refEmail;
	}



	@Override
	public String toString() {
		return "MemberEntity [memberId=" + memberId + ", memberName=" + memberName + ", memberGender=" + memberGender
				+ ", memberDob=" + memberDob + ", memberIdProof=" + memberIdProof + ", idProofNo=" + idProofNo
				+ ", vaccineType=" + vaccineType + ", dose=" + dose + ", refEmail=" + refEmail + "]";
	}

	

	

	
}
