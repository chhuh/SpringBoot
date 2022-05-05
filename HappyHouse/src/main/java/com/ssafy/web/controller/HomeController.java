package com.ssafy.web.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssafy.web.service.BoardService;
import com.ssafy.web.service.MemberService;
import com.ssafy.web.vo.BoardVO;
import com.ssafy.web.vo.MemberVO;

@RestController
public class HomeController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	BoardService boardService;
	
	
	@PostMapping("memberInsert")
	public String memberInsert(MemberVO vo) {
		if(vo.getId()=="") return "id를 입력하세요";
		else if(vo.getPw()=="") return "비밀번호를 입력하세요";
		else if(vo.getName()=="") return "이름을 입력하세요";
		else {
			memberService.memberInsert(vo);
			return "";
		}
	}
	@PostMapping("memberselectAll")
	public List<MemberVO> memberselectAll(){
		List<MemberVO> list=memberService.memberselectAll();
		System.out.println(list);
		return list;
	}
	
	@PostMapping("select")
	public MemberVO select(int no){
		System.out.println(no);
		return memberService.select(no);
	}
	
	@PostMapping("memberupdate")
	public void memberupdate(MemberVO vo) {
		memberService.memberupdate(vo);
	}
	
	@PostMapping("memberdelete")
	public void memberdelete(int no) {

		memberService.memberdelete(no);
	}
	
	@PostMapping("login")
	public String login(MemberVO vo,HttpSession session) {
		String name=memberService.login(vo);
		if(name!=null) {
			session.setAttribute("member", vo);
		}
		return name; 
	}
	
	@PostMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		session.invalidate();
		return "";
	}
	
	@PostMapping("board")
	public PageInfo<BoardVO> board(HttpServletRequest request){
		PageHelper.startPage(request);
		List<BoardVO> list=boardService.board();
		return PageInfo.of(list);
	}
}
