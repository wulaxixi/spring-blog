package me.woemler.springblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.woemler.springblog.services.AsyncService;

@Controller
@RequestMapping(value="/ProgressBar")
public class ProgressBarTestController {
	
	private final String CACHEKAY = "PLUSONENUMBER_YZY";
	
	@Autowired
	private AsyncService asyncService;

	@RequestMapping(value="plus")
	@ResponseBody
	public String plusOneNumber(){
		try {
			asyncService.asyncMethod(CACHEKAY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "正在处理...";
	}
	
	
	@RequestMapping(value="rtnProgress")
	@ResponseBody
	public Object rtnProgress(){
		try {
			Object p = asyncService.getProcess(CACHEKAY);
			if(p != null)return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
