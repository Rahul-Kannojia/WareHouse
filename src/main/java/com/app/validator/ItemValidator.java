package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		//down cast to Model class Type
		Item item=(Item)target;


		if(!Pattern.compile("[A-Z]{4,8}").matcher(item.getCode()).matches()) {
			errors.rejectValue("code", null, "Enter Valid code(4 to 8 Uppercase only)");
		}
		if(item.getL() <= 0 || item.getH() <= 0 || item.getW() <= 0) {
			errors.rejectValue("l", null, "Enter Valid dimensions");
		}
		if(item.getBaseCost()<=0) {
			errors.rejectValue("baseCost", null, "please enter baseCost");
		}
		if("".equals(item.getBaseCurrency())) {
			errors.rejectValue("baseCurrency", null, "Please choose Currency");
		}
		if(item.getUom() == null || item.getUom().getUid() ==null) {
			errors.rejectValue("uom", null, "Please choose one Uom");
		}
		if(item.getSaleType() == null || item.getSaleType().getId() ==null) {
			errors.rejectValue("saleType", null, "Please choose one Sale Type");
		}
		if(item.getPurchaseType() == null || item.getPurchaseType().getId() ==null) {
			errors.rejectValue("purchaseType", null, "Please choose one Purchase Type");
		}
		if(item.getVenUsers()==null ||item.getVenUsers().isEmpty()) {
			errors.rejectValue("venUsers", null, "plz select venUser");
		}
	}
}
