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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.validator.ShipmentTypeValidator;

@Controller
//provide url pattern class level
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;

	@Autowired
	private ShipmentTypeValidator validator;

	//request for registration page
	@RequestMapping("/reg")
	public String regUom(ModelMap map) 
	{
		//create model attribute object
		map.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	//click on submit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertUom(@ModelAttribute("shipmentType") ShipmentType shipmentType,ModelMap map,Errors errors)
	{
		System.out.println(shipmentType);
		validator.validate(shipmentType, errors);
		if(!errors.hasErrors()) {
			//no errors
			Integer i=service.saveShipmentType(shipmentType);
			String msg="SHIPMENT ID IS CREATED WITH=="+i+" SUCCESSFULLY";
			map.addAttribute("massege","ShipmentType create with id:"+msg);
			//cleare form data
			map.addAttribute("shipmentType",new ShipmentType());
		}
		return "ShipmentTypeRegister";
	}
	//3.get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<ShipmentType> st=service.getAllShipmentType();
		map.addAttribute("list",st);
		return "ShipmentTypeData";
	}

	//4.Delete employee by id
	@RequestMapping("/delete")
	public String deleteSmt(@RequestParam("id")Integer id,ModelMap map) {
		//call service layer delete
		service.deleteShipmentType(id);
		//construct final message
		String msg="Employee'"+id+"'Deleted";
		//get new data from DB
		List<ShipmentType> om=service.getAllShipmentType();
		//send to UI
		map.addAttribute("message",msg);
		map.addAttribute("list",om);
		return "ShipmentTypeData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer id,ModelMap map) {
		ShipmentType st=service.getOneShipmentTypeById(id);
		map.addAttribute("stm",st);
		return "ShipmentTypeEdit";
	}
	//6.do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateData(@ModelAttribute ShipmentType st,ModelMap map) {
		service.updateShipmentType(st);
		String msg="Employee'"+st.getId()+"'Updated";
		List<ShipmentType> stm=service.getAllShipmentType();
		map.addAttribute("message", msg);
		map.addAttribute("list",stm);
		return "ShipmentTypeData";
	}
}
