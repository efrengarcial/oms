package com.touresbalon.oms.orders.model.mgr;

import org.springframework.beans.factory.annotation.Autowired;

import com.touresbalon.oms.orders.model.dao.ParameterDao;

public class DummyManager {

	@Autowired
	ParameterDao parameterDao;
	
	
	public void dummy(){
		
	}
}
