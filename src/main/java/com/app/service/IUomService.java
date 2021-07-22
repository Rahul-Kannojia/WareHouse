package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Uom;
@Service
public interface IUomService {
	public Integer saveUom(Uom uom);
	public void updateUom(Uom uom);
	public void deleteUom(Integer uid);
	public Uom getOneUomById(Integer uid);
	public List<Uom> getAllUom();
	public boolean isUomModelExist(String Model);
}
