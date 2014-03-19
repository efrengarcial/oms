package com.touresbalon.oms.orders.model.mgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touresbalon.oms.orders.model.dao.ParameterDao;

@Service
public class DummyManager {

	@Autowired
	ParameterDao parameterDao;
	
	
	public void dummy(){
		
	}
}
