package com.touresbalon.oms.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.touresbalon.oms.products.model.entity.Espectaculo;
import com.touresbalon.oms.products.model.entity.Producto;
import com.touresbalon.oms.products.model.entity.TarifaBoleta;
import com.touresbalon.oms.products.model.entity.TarifaHospedaje;
import com.touresbalon.oms.products.model.entity.TarifaTransporte;
import com.touresbalon.oms.products.model.entity.TipoEspectaculo;
import com.touresbalon.oms.products.model.mgr.ProductManager;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired 
	ProductManager producMgr;
	
	@RequestMapping(value = "/allProducts",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Producto> allProductos(){
		return (List<Producto>)producMgr.findAll();
	}
	
	@RequestMapping(value = "/consultarProductos",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Producto> consultarProductos(int paginaActual, String codigoProducto, String nombreProducto, String descripcionProducto, Integer idEspectaculo){
		return producMgr.consultarProductos(paginaActual, codigoProducto,nombreProducto,descripcionProducto,((idEspectaculo!=null && idEspectaculo>0)?idEspectaculo:null));
	}
	
	@RequestMapping(value = "/findById",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Producto findById(int idProducto){
		return producMgr.find(idProducto);
	}
	
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
	@RequestMapping(value = "/findByIdTipoEspectaculo",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public TipoEspectaculo findTipoEspectaculo(int idTipoEspectaculo){
		return producMgr.findTipoEspectaculo(idTipoEspectaculo);
	}
	
	@RequestMapping(value = "/findAllEspectaculos",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Espectaculo> findAllEspectaculos(){
		return (List<Espectaculo>) producMgr.findAllEspectaculos();
	}
	
	@RequestMapping(value = "/findAllTarifaBoleta",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TarifaBoleta> findAllTarifaBoleta(){
		return (List<TarifaBoleta>) producMgr.findAllTarifaBoleta();
	}
	
	@RequestMapping(value = "/findAllTarifaTransporte",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TarifaTransporte> findAllTarifaTransporte(){
		return (List<TarifaTransporte>) producMgr.findAllTarifaTransporte();
	}
	
	@RequestMapping(value = "/findAllTarifaHospedaje",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TarifaHospedaje> findAllTarifaHospedaje(){
		return (List<TarifaHospedaje>) producMgr.findAllTarifaHospedaje();
	}
	
}
