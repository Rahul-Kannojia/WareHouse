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
import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.validator.ItemValidator;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService service;

	@Autowired
	private IUomService uomservice;

	@Autowired
	private IOrderMethodService omservice;

	@Autowired
	private IWhUserTypeService whuserservice;

	@Autowired
	private ItemValidator validator;

	@RequestMapping("/register")
	public String regItem(ModelMap map) {

		List<Uom> uoms = uomservice.getAllUom();
		map.addAttribute("uoms", uoms);

		List<OrderMethod> sales = omservice.getOrderMethodsByMode("sale");
		map.addAttribute("sales", sales);

		List<OrderMethod> purchases = omservice.getOrderMethodsByMode("purchase");
		map.addAttribute("purchases", purchases);

		List<WhUserType> vendors=whuserservice.getWhUserTypesByType("vendors");
		map.addAttribute("vendors", vendors);

		List<WhUserType> customers=whuserservice.getWhUserTypesByType("customers");
		map.addAttribute("customers", customers);

		map.addAttribute("item",new Item());
		return "ItemRegister";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertItem(@ModelAttribute("item") Item item,Errors errors,ModelMap map) {

		List<Uom> uoms = uomservice.getAllUom();
		map.addAttribute("uoms", uoms);


		validator.validate(item, errors); 
		if(!errors.hasErrors()) {
			//no errors
			Integer i=service.saveItem(item);
			String msg="your id is "+i+" successfully";
			map.addAttribute("message","item created with id:"+msg);
			map.addAttribute("item", new Item());
		}
		return "ItemRegister";
	}

	//3.get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Item> im=service.getAllItems();
		map.addAttribute("list",im);
		return "ItemData";
	}

	//4.Delete employee by id
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("id")Integer id,ModelMap map) {

		//call service layer delete
		service.deleteItem(id);

		//construct final message
		String msg="Item'"+id+"'Deleted";

		//get new data from DB
		List<Item> im=service.getAllItems();

		//send to UI
		map.addAttribute("message",msg);
		map.addAttribute("list",im);
		return "ItemData";
	}

	//5.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer id,ModelMap map) {

		List<Uom> uoms = uomservice.getAllUom();
		map.addAttribute("uoms", uoms);
		Item im=service.getOneItemById(id);
		map.addAttribute("item",im);
		return "ItemEdit";
	}
	//6.do update operation
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Item im,ModelMap map) {
		service.updateItem(im);
		String msg="Employee'"+im.getId()+"'Updated";
		List<Item> m=service.getAllItems();
		map.addAttribute("message", msg);
		map.addAttribute("list",m);
		return "ItemData";
	}

}
