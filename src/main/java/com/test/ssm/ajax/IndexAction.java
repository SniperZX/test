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
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", "aaa");
		List<UrlList> tmp = urlListService.getUrlList(page);
		return JSONObject.toJSONString(tmp);
	}
	
	@RequestMapping(value = "/detail",method = RequestMethod.GET, produces = {"text/javascript;charset=UTF-8"})
	public String getDetail(HttpServletRequest request, HttpServletResponse response, @RequestParam("url") String url){
		
		List<DetailWithBLOBs> details = urlListService.getDetailFromUrl(url);
		return JSONObject.toJSONString(details);
	}
	
	
}
