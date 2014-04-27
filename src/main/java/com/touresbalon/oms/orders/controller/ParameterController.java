package com.touresbalon.oms.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.touresbalon.oms.orders.model.dao.ParameterDao;


@Controller
@RequestMapping("/parameters")
public class ParameterController {

	@Autowired ParameterDao parameterDao;

//	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<Parameter> allStories() {
//		return (List<Parameter>) parameterDao.findAll();
//	}
}
