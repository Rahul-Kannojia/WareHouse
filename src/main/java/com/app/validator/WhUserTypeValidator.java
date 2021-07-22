package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
@Component
public class WhUserTypeValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return WhUserType.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		//down cast to Model class Type
		WhUserType whuser=(WhUserType)target;

		if("".equals(whuser.getType())) {
			errors.rejectValue("type", null, "please enter type");
		}
		if(!Pattern.compile("[A-Za-z0-9]{4,8}").matcher(whuser.getCode()).matches()){
			errors.rejectValue("code", null, "please enter code");
		}
		if(!Pattern.compile("[A-Za-z]{3,8}").matcher(whuser.getForType()).matches()) {
			errors.rejectValue("forType", null, "please enter forType");
		}
		if(!Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}").matcher(whuser.getEmail()).matches()) {
			errors.rejectValue("email", null,"Please Enter Valid Email");
		}
		if(!Pattern.compile("((\\+){1}91){1}[1-9]{1}[0-9]{9}").matcher(whuser.getContact()).matches()) {
			errors.rejectValue("contact", null,"Please Enter Valid Contact");
		}
		if("".equals(whuser.getIdType())) {
			errors.rejectValue("idType", null, "please enter idType");
		}
		if("OTHER".equals(whuser.getIdType()) && "".equals(whuser.getIfOther())) {
			errors.rejectValue("ifOther", null, "please enter ifOther");
		}
		if("".equals(whuser.getIdNum())) {
			errors.rejectValue("idNum", null, "please enter idNum");
		}

	}

}
