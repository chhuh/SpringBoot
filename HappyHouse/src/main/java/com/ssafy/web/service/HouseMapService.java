package com.ssafy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.web.dao.HouseMapDAO;
import com.ssafy.web.vo.HouseInfoVO;
import com.ssafy.web.vo.SidoGugunCodeVO;



@Service
public class HouseMapService  {
	
	@Autowired
	private HouseMapDAO houseMapDAO;


	public List<SidoGugunCodeVO> getSido()  {
		return houseMapDAO.getSido();
	}


	public List<SidoGugunCodeVO> getGugunInSido(String sido) throws Exception {
		return houseMapDAO.getGugunInSido(sido);
	}


	public List<HouseInfoVO> getDongInGugun(String gugun) throws Exception {
		return houseMapDAO.getDongInGugun(gugun);
	}


	public List<HouseInfoVO> getAptInDong(String dong) throws Exception {
		return houseMapDAO.getAptInDong(dong);
	}

}
