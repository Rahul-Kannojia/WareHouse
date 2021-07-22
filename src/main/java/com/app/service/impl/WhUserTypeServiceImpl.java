package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType wht) {
		return dao.saveWhUserType(wht);
	}

	@Transactional
	public void updateWhUserType(WhUserType wht) {
		dao.updateWhUserType(wht);
	}

	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);	
	}

	@Transactional(readOnly=true)
	public WhUserType getOneWhUserTypeById(Integer wht) {
		return dao.getOneWhUserTypeById(wht);
	}

	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserType() {
		return dao.getAllWhUserType();
	}
     
	@Transactional(readOnly=true)
	public List<WhUserType> getWhUserTypesByType(String userType) {
		
		return dao.getWhUserTypesByType(userType);
	}
}
