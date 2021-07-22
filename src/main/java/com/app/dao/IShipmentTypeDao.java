package com.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.model.ShipmentType;
@Repository
public interface IShipmentTypeDao {
	public Integer saveShipmentType(ShipmentType st);
	public void updateShipmentType(ShipmentType st);
	public void deleteShipmentType(Integer id);
	public ShipmentType getOneShipmentTypeById(Integer id);
	public List<ShipmentType> getAllShipmentType();
}
