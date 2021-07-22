package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	
	@Transactional
	public Integer saveOrderMethod(OrderMethod sm) {
		return dao.saveOrderMethod(sm);
	}

	@Transactional
	public void updateOrderMethod(OrderMethod sm) {
		dao.updateOrderMethod(sm);
		
	}

	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);
		
	}

	@Transactional(readOnly=true)
	public OrderMethod getOneOrderMethodById(Integer id) {
		return dao.getOneOrderMethodById(id);
	}
	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrderMethod() {
		return dao.getAllOrderMethod();
	}
	
    @Transactional(readOnly=true)
	public List<OrderMethod> getOrderMethodsByMode(String mode) {
    	return dao.getOrderMethodsByMode(mode);
	}

}
