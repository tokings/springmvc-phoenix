package com.embracesource.phoenix.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.embracesource.phoenix.service.TestService;

@Controller
public class TestController {
	
	private Logger log = LoggerFactory.getLogger("phoenix");
	
	@Resource
	private TestService testService;
	
	@RequestMapping("/test")
	public @ResponseBody String test() {
		log.info("test spring phoenix");
		return "hello, world! This com from spring!";
	}
	
	@RequestMapping("/phoenix/test")
	@ResponseBody
	public List<Map<String, Object>> phoenixTest() {
		return testService.phoenixTest();
	}
}
