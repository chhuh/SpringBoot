package com.ssafy.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.web.service.HouseMapService;
import com.ssafy.web.vo.HouseInfoVO;
import com.ssafy.web.vo.SidoGugunCodeVO;



@RestController
@RequestMapping("/map")
public class HouseMapController {


	@Autowired
	private HouseMapService houseMapService;
	
	@GetMapping("/sido")
	public List<SidoGugunCodeVO> sido() {
		return houseMapService.getSido() ;
	}
	
	@GetMapping("/gugun")
	public List<SidoGugunCodeVO> gugun(String sido) throws Exception{
		return houseMapService.getGugunInSido(sido);
	}
	
	@GetMapping("/dong")
	public List<HouseInfoVO> dong(String gugun) throws Exception {
		return houseMapService.getDongInGugun(gugun);
	}
	
	@GetMapping("/apt")
	public List<HouseInfoVO> apt(String dong) throws Exception {
		return houseMapService.getAptInDong(dong);
	}
	
}
