package com.touresbalon.oms.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.touresbalon.oms.orders.model.dao.ParameterDao;
import com.touresbalon.oms.orders.model.entity.Parameter;


@Controller
@RequestMapping("/parameters")
public class ParameterController {

	@Autowired ParameterDao parameterDao;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Parameter> allStories() {
		return (List<Parameter>) parameterDao.findAll();
	}
}
