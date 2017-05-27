package com.test.ssm.ajax;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.test.ssm.domain.DetailWithBLOBs;
import com.test.ssm.domain.UrlList;
import com.test.ssm.service.UrlListService;

@RestController
@RequestMapping("/ajax/index")
public class IndexAction {

	@Autowired
	private UrlListService urlListService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET, produces = {"text/javascript;charset=UTF-8"})
	public String getList(HttpServletRequest request, HttpServletResponse response, @RequestParam("page") int page){
		int totalNum = urlListService.getUrlListTotalPage();
		int totalPage = 0;
		if(totalNum%20!=0){
			totalPage = ((int)totalNum/20)+1;
		}else{
			totalPage = ((int)totalNum/20);
		}
		
		List<UrlList> tmp = urlListService.getUrlList(page);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("totalPage", totalPage);
		jsonObject.put("data", tmp);
		return jsonObject.toJSONString();
	}
	
	@RequestMapping(value = "/detail",method = RequestMethod.GET, produces = {"text/javascript;charset=UTF-8"})
	public String getDetail(HttpServletRequest request, HttpServletResponse response, @RequestParam("url") String url){
		
		List<DetailWithBLOBs> details = urlListService.getDetailFromUrl(url);
		return JSONObject.toJSONString(details);
	}
	
	
}
