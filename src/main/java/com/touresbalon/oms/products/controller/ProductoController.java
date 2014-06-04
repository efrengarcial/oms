package com.touresbalon.oms.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.touresbalon.oms.products.model.entity.Producto;
import com.touresbalon.oms.products.model.mgr.ProductManager;


@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired 
	ProductManager producMgr;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody
	Producto save(@RequestBody Producto producto){
		return producMgr.create(producto);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody
	void create(@RequestBody Producto producto){
		producMgr.create(producto);
	}
}
