package com.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Component
public class UserIdToObjectConverter implements Converter<Object,WhUserType> {
	
	@Autowired
	private IWhUserTypeService service;

	@Override
	public WhUserType convert(Object wid) {
        int id=Integer.parseInt((String)wid);
		return service.getOneWhUserTypeById(id);
	}
	

}
