package com.touresbalon.oms.orders.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touresbalon.oms.orders.model.entity.Item;
import com.touresbalon.oms.orders.model.entity.Order;
import com.touresbalon.oms.orders.model.mgr.OrderManager;
import com.touresbalon.oms.orders.model.service.OrderService;
import com.touresbalon.oms.orders.model.service.dto.ItemDto;
import com.touresbalon.oms.orders.model.service.dto.OrderDto;

@Service("orderService") 
@WebService(endpointInterface="com.touresbalon.oms.orders.model.service.OrderService",serviceName = "OrderService",
targetNamespace = "http://www.touresbalon.com/oms/orders/1.0", portName = "OrderServicePort")
public class OrderServiceImpl  implements OrderService {
	
	@Autowired
	private OrderManager orderManager;
	
	@Override
	public void updateStateOrder(OrderDto orderDto) {
		Order order = orderManager.find(orderDto.getOrdId());
		order.setEndOrderDate(orderDto.getEndOrderDate());
		order.setStatus(orderDto.getStatus());
		orderManager.update(order);
	}

	@Override	
	public OrderDto createOrder(OrderDto orderDto) {			
		Order orderCreated = orderManager.create(orderDtoToOrder(orderDto));
		orderDto.setOrdId(orderCreated.getOrdId());
		return orderDto;
	}	
	
	private Order orderDtoToOrder(OrderDto dto){
		Order order = new Order();
		order.setComments(dto.getComments());
		order.setCustId(dto.getCustId());
		order.setEndOrderDate(dto.getEndOrderDate());
		order.setOrderDate(dto.getOrderDate());
		order.setPrice(dto.getPrice());
		order.setShowType(dto.getShowType());
		order.setStatus(dto.getStatus());
		List<Item>  items = new ArrayList<>();
		for (ItemDto itemDto : dto.getItems()) {
			Item item  = new Item();
			items.add(item);
			item.setCustId(dto.getCustId());
			item.setItemDate(itemDto.getItemDate());
			item.setOrder(order);
			item.setPartNum(itemDto.getPartNum());
			item.setPrice(itemDto.getPrice());
			item.setProdId(itemDto.getProdId());
			item.setProductName(itemDto.getProductName());
			item.setQuantity(itemDto.getQuantity());
		}
		order.setItems(items);
		
		return order;
	}
	
}
