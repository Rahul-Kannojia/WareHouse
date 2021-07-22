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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;


@Controller
//provide url pattern class level
@RequestMapping("/uom")
public class UomController 
{
	@Autowired
	private IUomService service;

	@Autowired
	private UomValidator validator;

	//request for registration page
	@RequestMapping("/reg")
	public String regUom(ModelMap map) 
	{
		//create model attribute object
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	//click on submit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertUom(@ModelAttribute Uom uom, Errors errors,ModelMap map)
	{
		validator.validate(uom, errors);
		if(!errors.hasErrors()) {
			//no errors
			Integer i=service.saveUom(uom);
			String msg="YOUR ID IS CREATED WITH=="+i+" SUCCESSFULLY";
			map.addAttribute("massege","Uom create with Id:"+msg);
			//clear form data
			map.addAttribute("uom",new Uom());
		}
		return "UomRegister";
	}
	//3.get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Uom> um=service.getAllUom();
		map.addAttribute("list",um);
		return "UomData";
	}
	//4.Delete employee by id
	@RequestMapping("/delete")
	public String deleteUm(@RequestParam("id")Integer id,ModelMap map) {
		//call service layer delete
		service.deleteUom(id);
		//construct final message
		String msg="Uom'"+id+"'Deleted";
		//get new data from DB
		List<Uom> om=service.getAllUom();
		//send to UI
		map.addAttribute("message",msg);
		map.addAttribute("list",om);
		return "UomData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer id,ModelMap map) {
		Uom uom=service.getOneUomById(id);
		map.addAttribute("um",uom);
		return "UomEdit";
	}
	//6.do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Uom um,ModelMap map) {
		service.updateUom(um);
		String msg="Employee'"+um.getUid()+"'Updated";
		List<Uom> uom=service.getAllUom();
		map.addAttribute("message", msg);
		map.addAttribute("list",uom);
		return "UomData";
	}

}
