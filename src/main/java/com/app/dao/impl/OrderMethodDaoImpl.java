package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;


	public Integer saveOrderMethod(OrderMethod sm) {
		return (Integer) ht.save(sm);	
	}

	public void updateOrderMethod(OrderMethod sm) {
		ht.update(sm);
	}
	public void deleteOrderMethod(Integer id) {
		OrderMethod om=new OrderMethod();
		om.setId(id);
		ht.delete(om);

	}

	public OrderMethod getOneOrderMethodById(Integer id) {
		return ht.get(OrderMethod.class, id);

	}

	public List<OrderMethod> getAllOrderMethod() {
		List<OrderMethod> list=ht.loadAll(OrderMethod.class);
		return list;
	}

	@SuppressWarnings({"unchecked" })
	public List<OrderMethod> getOrderMethodsByMode(String mode) {
		return (List<OrderMethod>) ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class).add(Restrictions.eq("mode", mode)));
	}
}

