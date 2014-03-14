package com.touresbalon.oms.products.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.touresbalon.oms.domain.oracle.Producto;


@Controller
@RequestMapping("/products")
public class ProductController {
	

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Producto> allProductoos() {
		Producto[]  productos =  { 
		  		        new Producto("APL", "Apple", "Eat one every day to keep the doctor away!",new BigDecimal(12000)),
		  		        new Producto("AVC", "Avocado", "Guacamole anyone?", new BigDecimal(16000)),
		  		        new Producto("BAN", "Banana", "These are rich in Potassium and easy to peel.",new BigDecimal(4000)),
		  		        new Producto("CTP", "Cantaloupe", "Delicious and refreshing.",new BigDecimal(3000)),
		  		        new Producto("FIG", "Fig", "OK, not that nutritious, but sooo good!",new BigDecimal(10000)),
		  		        new Producto("GRF", "Grapefruit", "Pink or red, always healthy and delicious.",new BigDecimal(11000)),
		  		        new Producto("GRP", "Grape", "Wine is great, but grapes are even better.",new BigDecimal(8000)),
		  		        new Producto("GUA", "Guava", "Exotic, fragrant, tasty!",new BigDecimal(8000)),
		  		        new Producto("KIW", "Kiwi", "These come from New Zealand.",new BigDecimal(14000)),
		  		        new Producto("LYC", "Lychee", "Unusual and highly addictive!",new BigDecimal(18000)),
		  		        new Producto("MAN", "Mango", "Messy to eat, but well worth it.",new BigDecimal(8000)),
		  		        new Producto("ORG", "Orange", "Vitamin C anyone? Go ahead, make some juice.",new BigDecimal(9000)),
		  		        new Producto("PAP", "Papaya", "Super-popular for breakfast.",new BigDecimal(5000)),
		  		        new Producto("PCH", "Peach", "Add some cream and enjoy.",new BigDecimal(19000)),
		  		        new Producto("PER", "Pear", "Delicious fresh, or cooked in red wine, or distilled.",new BigDecimal(8000)),
		  		        new Producto("PMG", "Pomegranate", "Delicious, healthy, beautiful, and sophisticated!",new BigDecimal(19000)),
		  		        new Producto("PNP", "Pineapple", "Enjoy it (but don't forget to peel first).",new BigDecimal(4000)),
		  		        new Producto("PSM", "Persimmon", "Believe it or not, they are berries!",new BigDecimal(6000)),
		  		        new Producto("STR", "Strawberry", "Beautiful, healthy, and delicious.",new BigDecimal(7000)),
		  		        new Producto("TNG", "Tangerine", "Easier to peel than oranges!",new BigDecimal(8000)),
		  		        new Producto("WML", "Watermelon", "Nothing comes close on those hot summer days.",new BigDecimal(4000))
		};
		return Lists.newArrayList(productos);
	}
}
