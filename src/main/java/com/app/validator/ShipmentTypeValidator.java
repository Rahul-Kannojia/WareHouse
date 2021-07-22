package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		//down cast to Model class type
		ShipmentType shipment=(ShipmentType)target;

		/*if("".equals(shipment.getId())) {
			errors.rejectValue("id", null,"please enter one id");
		}*/
		if("".equals(shipment.getMode().trim())) {
			errors.rejectValue("mode", null,"please select mode");
		}
		if(!Pattern.compile("[A-Za-z0-9]{3,10}").matcher(shipment.getCode()).matches()) {
			errors.rejectValue("code", null, "plz enter code");
		}
		if(shipment.getEnabled()==null||shipment.getEnabled().isEmpty()) {
			errors.rejectValue("enabled", null,"please select enabled");
		}
		if(shipment.getGrade()==null) {
			errors.rejectValue("grade", null, "please enter grade");
		}
		if(!Pattern.compile("[A-Za-z-0-9]{10,100}").matcher(shipment.getDsc()).matches()){
			errors.rejectValue("dsc", null, "please enter description");
		}

	}

}
