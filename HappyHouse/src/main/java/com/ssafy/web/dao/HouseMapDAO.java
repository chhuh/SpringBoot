package com.ssafy.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssafy.web.vo.HouseInfoVO;
import com.ssafy.web.vo.SidoGugunCodeVO;


@Mapper
@Repository
public interface HouseMapDAO {

	List<SidoGugunCodeVO> getSido() throws DataAccessException;
	List<SidoGugunCodeVO> getGugunInSido(String sido) throws DataAccessException;
	List<HouseInfoVO> getDongInGugun(String gugun) throws DataAccessException;
	List<HouseInfoVO> getAptInDong(String dong) throws DataAccessException;
	
}
