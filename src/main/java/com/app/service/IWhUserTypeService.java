package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {

	public Integer saveWhUserType(WhUserType wht);

	public void updateWhUserType(WhUserType wht);

	public void deleteWhUserType(Integer id);

	public WhUserType getOneWhUserTypeById(Integer wht);

	public List<WhUserType> getAllWhUserType();

	public List<WhUserType> getWhUserTypesByType(String userType);
}
