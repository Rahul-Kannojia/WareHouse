package com.app.dao;

import java.util.List;
import com.app.model.Uom;

public interface IUomDao {
	public Integer saveUom(Uom uom);
	public void updateUom(Uom uom);
	public void deleteUom(Integer uid);
	public Uom getOneUomById(Integer uid);
	public List<Uom> getAllUom();
	public boolean isUomModelExist(String Model);
}
