package com.ssafy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.web.dao.MemberDAO;
import com.ssafy.web.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	public void memberInsert(MemberVO vo) {
		memberDAO.memberInsert(vo);
	}

	public String login(MemberVO vo) {
		return memberDAO.login(vo);
		
	}

	public List<MemberVO> memberselectAll() {
		// TODO Auto-generated method stub
		return memberDAO.memberselectAll();
	}

	public void memberupdate(MemberVO vo) {
		
		memberDAO.memberupdate(vo);
	}

	public MemberVO select(int no) {
		return memberDAO.select(no);
	}

	public void memberdelete(int no) {
		memberDAO.memberdelete(no);
		
	}
}
