package com.tap.vaccine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.entity.MemberEntity;
import com.tap.vaccine.service.AddMemberService;

@Controller
public class AddMemberController {
	
	private AddMemberService memberservice;
	private LoginController loginController;
	
	@Autowired
	public AddMemberController(AddMemberService memberservice,LoginController loginController) {
		this.memberservice = memberservice;
		this.loginController = loginController;
	}

	
	@RequestMapping(value="/goToHomePage")
	public String homePage(Model model) {
		return "/WEB-INF/Home.jsp";
	}
	
	@RequestMapping(value="/gotoMemberPage")
	public String memberPage(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String email=(String) (session.getAttribute("email"));
		model.addAttribute("refEmail",email);
		return "/WEB-INF/Member.jsp";
	}
	
	@RequestMapping(value="/addmemberPage")
	public String addMember(@RequestParam String memberName,@RequestParam String membergender,@RequestParam String memberDOB,@RequestParam String memberidProof,@RequestParam String idProofno,@RequestParam String vaccineType,@RequestParam int dose,@RequestParam String refemail,Model model,HttpServletRequest request) {
		boolean isValid=memberservice.ValidateData(memberName,membergender,memberDOB,memberidProof,idProofno,vaccineType,dose,refemail);
		HttpSession session = request.getSession();
		if(isValid) {
			System.out.println("Controller valid");
			boolean isSaved=memberservice.saveMember(memberName,membergender,memberDOB,memberidProof,idProofno,vaccineType,dose,refemail);
			loginController.checkCredentials((String)session.getAttribute("email"),(String)session.getAttribute("password"),model,request);
			if(isSaved) {
				System.out.println("Controller saved");
				model.addAttribute("memberresponse","Data is valid && saved");
			}else {
				model.addAttribute("memberresponse","Adding members are exceed");
			}
		}else {
			model.addAttribute("memberresponse","Data is invalid enter correct data");
		}
		return "/WEB-INF/Home.jsp";
	}
	@RequestMapping(value="/getAllMembers")
	public String viewPage(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String email=(String) (session.getAttribute("email"));
		List<MemberEntity> result=memberservice.getMemberData(email);
		model.addAttribute("Members", result);
		return "/WEB-INF/Member.jsp";
	}
	@RequestMapping(value="/EditMember/{id}")
	public String editPage(@PathVariable int id,Model model) {
		MemberEntity entity=memberservice.getMemberData(id);
		model.addAttribute("memberId",entity.getMemberId());
		model.addAttribute("memberName",entity.getMemberName());
		model.addAttribute("membergender",entity.getMemberGender());
		model.addAttribute("memberDOB",entity.getMemberDob());
		model.addAttribute("memberidProof",entity.getMemberIdProof());
		model.addAttribute("idproof",entity.getIdProofNo());
		model.addAttribute("vaccineType",entity.getVaccineType());
		model.addAttribute("dose",entity.getDose());
		model.addAttribute("refEmail",entity.getRefEmail());
		
		return "/WEB-INF/Edit.jsp";
	}
	@RequestMapping(value="/Edit",method = RequestMethod.POST)
	public String editMember(@RequestParam int memberid,@RequestParam String memberName,@RequestParam String membergender,@RequestParam String memberDOB,@RequestParam String memberidProof,@RequestParam String idProofno,@RequestParam String vaccineType,@RequestParam int dose,@RequestParam String refemail,Model model) {
		System.out.println("edit controller");
		boolean result=memberservice.editMember(memberid,memberName,membergender,memberDOB,memberidProof,idProofno,vaccineType,dose,refemail);
		if(result) {
			model.addAttribute("editresponse","member data is updated successfully");
		}else {
			model.addAttribute("editresponse","member is not updated");
		}
		return "/WEB-INF/Edit.jsp";
	}
	
	@RequestMapping(value="/addMember")
	public String addMember() {
		return "/WEB-INF/Home.jsp";
	}
	
	@RequestMapping(value="/DeleteMember/{id}")
	public String deleteMember(@PathVariable int id,Model model,HttpServletRequest request) {
		System.out.println("Delete Controller");
		MemberEntity entity=memberservice.getMemberData(id);
		HttpSession session = request.getSession();
		boolean result=memberservice.deleteMember(entity);
		
		if(result) {
			memberservice.updateRegisterEntityMemberCount(entity.getRefEmail());
			
			loginController.checkCredentials((String)session.getAttribute("email"),(String)session.getAttribute("password"),model,request);
			model.addAttribute("deleteStatus","Member data is successfully deleted");
		}
		return "redirect:/addMember";
	}
}
