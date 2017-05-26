package com.test.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ssm.domain.DetailWithBLOBs;
import com.test.ssm.domain.UrlList;
import com.test.ssm.mapper.DetailMapper;
import com.test.ssm.mapper.UrlListMapper;

@Service
public class UrlListService {
	
	@Autowired
	private UrlListMapper urlListMapper;
	
	@Autowired
	private DetailMapper detailMapper;
	
	public List<UrlList> getUrlList(int page){
		List<UrlList> tmpList = urlListMapper.selectListByPage(page*20);
		return tmpList;
	}

	public List<DetailWithBLOBs> getDetailFromUrl(String url) {
		List<DetailWithBLOBs> tmpList = detailMapper.getDetailFromUrl(url);
		return tmpList;
	}
	
	
}
