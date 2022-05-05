package com.ssafy.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssafy.web.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {

	public void memberInsert(MemberVO vo)throws DataAccessException;

	public String login(MemberVO vo) throws DataAccessException;

	public List<MemberVO> memberselectAll() throws DataAccessException;

	public void memberupdate(MemberVO vo) throws DataAccessException;

	public MemberVO select(int no) throws DataAccessException;

	public void memberdelete(int no) throws DataAccessException;
}
