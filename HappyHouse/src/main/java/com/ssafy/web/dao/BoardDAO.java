package com.ssafy.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.ssafy.web.vo.BoardVO;

@Mapper
@Repository
public interface BoardDAO {

	public List<BoardVO> board() throws DataAccessException;

}
