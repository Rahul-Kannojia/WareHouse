package com.app.service;

import java.util.List;


import com.app.model.OrderMethod;

public interface IOrderMethodService {
	
	public Integer saveOrderMethod(OrderMethod sm);
	
	public void updateOrderMethod(OrderMethod sm);
	
	public void deleteOrderMethod(Integer id);
	
	public OrderMethod getOneOrderMethodById(Integer id);
	
	public List<OrderMethod> getAllOrderMethod();
	
	public  List<OrderMethod> getOrderMethodsByMode(String mode);
}
