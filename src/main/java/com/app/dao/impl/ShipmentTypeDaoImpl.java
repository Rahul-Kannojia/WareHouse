package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveShipmentType(ShipmentType st) {
		return (Integer)ht.save(st);
	}
	public void updateShipmentType(ShipmentType st) {
		ht.update(st);
	}
	public void deleteShipmentType(Integer id) {
		ShipmentType s=new ShipmentType();
		s.setId(id);
		ht.delete(s);
	}
	public ShipmentType getOneShipmentTypeById(Integer id) {
		return ht.get(ShipmentType.class,id);
	}
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType> list=ht.loadAll(ShipmentType.class);
		return list;
	}

}
