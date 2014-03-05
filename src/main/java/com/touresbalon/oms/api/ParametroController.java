package com.touresbalon.oms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.touresbalon.oms.domain.oracle.Parametro;
import com.touresbalon.oms.repository.oracle.ParametroRepository;


@Controller
@RequestMapping("/parametros")
public class ParametroController {

	@Autowired ParametroRepository parametroRepository;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Parametro> allStories() {
		return (List<Parametro>) parametroRepository.findAll();
	}
}
