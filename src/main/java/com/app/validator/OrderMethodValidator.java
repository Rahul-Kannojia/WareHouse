package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

@Component
public class OrderMethodValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//down cast to model class type
		OrderMethod order = (OrderMethod) target;

		if(order.getMode()==null||"".equals(order.getMode())) {
			errors.rejectValue("mode", null, "please choose one mode");
		}
		if(!Pattern.compile("[A-Z]{3,7}").matcher(order.getCode()).matches()) {
			errors.rejectValue("code", null, "Enter valid code(3 to 7 upperCase only)");
		}
		if(!Pattern.compile("[A-Za-z0-9]{10,100}").matcher(order.getDc()).matches()) {
			errors.rejectValue("dc", null, "please enter Description");
		}
		if("".equals(order.getMethod().trim())) {
			errors.rejectValue("method", null,"please enter method");
		}
		if(order.getAccept()==null||order.getAccept().isEmpty()) {
			errors.rejectValue("accept", null, "plz choose atleast one option");
		}
	}
}
