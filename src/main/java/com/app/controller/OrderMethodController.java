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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;
@Controller
//provide url pattern class level
@RequestMapping("/ordmt")
public class OrderMethodController {


	@Autowired
	private IOrderMethodService service;

	@Autowired
	private OrderMethodValidator validator;

	//request for registration page
	@RequestMapping("/reg")
	public String regOrderMethod(ModelMap map) 
	{
		//create model attribute object
		map.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
	//click on submit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertOrderMethod(@ModelAttribute OrderMethod orderMethod, Errors errors, ModelMap map)
	{
		validator.validate(orderMethod, errors);
		if(!errors.hasErrors()) {
			//no errors
			Integer id=service.saveOrderMethod(orderMethod);
			String msg="YOUR ID IS CREATED WITH=="+id+" SUCCESSFULLY";
			map.addAttribute("massege","OrderMethod created with id:"+msg);
			//clear form data
			map.addAttribute("orderMethod" ,new OrderMethod());
		}

		return "OrderMethodRegister";
	}
	//3.get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<OrderMethod> om=service.getAllOrderMethod();
		map.addAttribute("list",om);
		return "OrderMethodData";
	}

	//4.Delete employee by id
	@RequestMapping("/delete")
	public String deleteOmd(@RequestParam("id")Integer id,ModelMap map) {
		//call service layer delete
		service.deleteOrderMethod(id);
		//construct final message
		String msg="Employee'"+id+"'Deleted";
		//get new data from DB
		List<OrderMethod> om=service.getAllOrderMethod();
		//send to UI
		map.addAttribute("message",msg);
		map.addAttribute("list",om);
		return "OrderMethodData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer id,ModelMap map) {
		OrderMethod om=service.getOneOrderMethodById(id);
		map.addAttribute("ordm",om);
		return "OrderMethodEdit";
	}
	//6.do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateData(@ModelAttribute OrderMethod omd,ModelMap map) {
		service.updateOrderMethod(omd);
		String msg="Employee'"+omd.getId()+"'Updated";
		List<OrderMethod> om=service.getAllOrderMethod();
		map.addAttribute("message", msg);
		map.addAttribute("list",om);
		return "OrderMethodData";
	}       
}
