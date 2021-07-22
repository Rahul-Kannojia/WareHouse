package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Vendor;
import com.app.service.IVendorService;

@Controller
//provide url pattern class level
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private IVendorService service;

	//request for registration page
	@RequestMapping("/register")
	public String regVendor(ModelMap map) {

		//create model attribute object
		map.addAttribute("ven",new Vendor());
		return "VendorRegister";
	}
	//click on submit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertVendor(@ModelAttribute Vendor vendor,ModelMap map) {

		Integer i=service.saveVendor(vendor);
		String msg="YOUR ID IS CREATED WITH=="+i+" SUCCESSFULLY";
		map.addAttribute("massege","Vendor create with Id:"+msg);
		//clear form data
		map.addAttribute("ven",new Vendor());
		return "VendorRegister";
	}
	//3.get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Vendor> vendor=service.getAllVendors();
		map.addAttribute("list",vendor);
		return "VendorData";
	}

	//4.Delete employee by id
	@RequestMapping("/delete")
	public String deleteUm(@RequestParam("venId")Integer venId,ModelMap map) {

		//call service layer delete
		service.deleteVendor(venId);
		//construct final message
		String msg="Vendor'"+venId+"'Deleted";
		//get new data from DB
		List<Vendor> ven=service.getAllVendors();
		//send to UI
		map.addAttribute("message",msg);
		map.addAttribute("list",ven);
		return "VendorData";
	}

	//5.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("venId")Integer venId,ModelMap map) {
		Vendor vendor=service.getOneVendorById(venId);
		map.addAttribute("ven",vendor);
		return "VendorEdit";
	}
	//6.do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Vendor vendor,ModelMap map) {
		service.updateVendor(vendor);
		String msg="Employee'"+vendor.getVenId()+"'Updated";
		List<Vendor> ven=service.getAllVendors();
		map.addAttribute("message", msg);
		map.addAttribute("list",ven);
		return "VendorData";
	}

}
