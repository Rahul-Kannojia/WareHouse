package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.ShipmentType;
@Service
public interface IShipmentTypeService {
	public Integer saveShipmentType(ShipmentType st);
	public void updateShipmentType(ShipmentType st);
	public void deleteShipmentType(Integer id);
	public ShipmentType getOneShipmentTypeById(Integer id);
	public List<ShipmentType> getAllShipmentType();
}
