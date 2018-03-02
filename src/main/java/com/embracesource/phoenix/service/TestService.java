package com.embracesource.phoenix.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.embracesource.phoenix.dao.TestDao;

@Service
public class TestService {

	@Resource
	private TestDao testDao;
	
	public List<Map<String, Object>> phoenixTest() {
		
		return testDao.phoenixTest();
	}

}
