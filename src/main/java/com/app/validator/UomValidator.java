package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;

@Component
public class UomValidator implements Validator {

	@Autowired
	private IUomService service;


	public boolean supports(Class<?> clazz) {

		return Uom.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		//down cast to model class type
		Uom uom=(Uom)target;

		if("".equals(uom.getType().trim())) {
			errors.rejectValue("type", null,"please choose one Type");
		}
		if(!Pattern.compile("[A-Z]{4,10}").matcher(uom.getModel()).matches()) {
			errors.rejectValue("model", null, "Enter valid model[4 to 10 upperCase only]");
		}
		else if(service.isUomModelExist(uom.getModel())) {
			errors.rejectValue("model",null,"uom model already exist,please choose other");

		}
		if(!Pattern.compile("[A-Za-z]{10,100}").matcher(uom.getDc()).matches()){
			errors.rejectValue("dc", null,"please enter Description");
		}
	}
}
