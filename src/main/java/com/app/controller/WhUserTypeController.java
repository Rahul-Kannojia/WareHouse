package com.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidator;

@Controller
//provide url pattern class level
@RequestMapping("/whts")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;

	@Autowired
	private WhUserTypeValidator validator;

	//request for registration page
	@RequestMapping("/register")
	public String regUom(ModelMap map) 
	{
		//create model attribute object
		map.addAttribute("whuserType",new WhUserType());
		return "WhUserTypeRegister";
	}
	//click on submit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertUom(@ModelAttribute("whuserType") WhUserType whuserType,ModelMap map, Errors errors)
	{
		validator.validate(whuserType, errors);
		if(!errors.hasErrors()) {
			//no errors
			Integer i=service.saveWhUserType(whuserType);
			String msg="YOUR ID IS CREATED WITH=="+i+" SUCCESSFULLY";
			map.addAttribute("massege","WhUserType created with id:"+msg);
			//cleare form data
			map.addAttribute("whuserType",new WhUserType());

		}

		return "WhUserTypeRegister";
	}
	//3.get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<WhUserType> wht=service.getAllWhUserType();
		map.addAttribute("list",wht);
		return "WhUserTypeData";
	}

	//4.Delete employee by id
	@RequestMapping("/delete")
	public String deleteOmd(@RequestParam("id")Integer id,ModelMap map) {
		//call service layer delete
		service.deleteWhUserType(id);
		//construct final message
		String msg="WarehouseUserType'"+id+"'Deleted";
		//get new data from DB
		List<WhUserType> wht=service.getAllWhUserType();
		//send to UI
		map.addAttribute("message",msg);
		map.addAttribute("list",wht);
		return "WhUserTypeData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer id,ModelMap map) {
		WhUserType wst=service.getOneWhUserTypeById(id);
		map.addAttribute("wt",wst);
		return "WhUserTypeEdit";
	}
	//6.do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateData(@ModelAttribute WhUserType wt,ModelMap map) {
		service.updateWhUserType(wt);
		String msg="Employee'"+wt.getId()+"'Updated";
		List<WhUserType> w=service.getAllWhUserType();
		map.addAttribute("message",msg);
		map.addAttribute("list",w);
		return "WhUserTypeData";
	}
}
