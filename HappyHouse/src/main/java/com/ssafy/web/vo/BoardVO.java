package com.ssafy.web.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private int code,originNo,groupOrd,groupLayer;
    private String title,content,writer;
    private Date reg_datetime;
	
}
