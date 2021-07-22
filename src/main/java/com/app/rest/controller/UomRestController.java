package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {

	@Autowired
	private IUomService service;

	//1.Get all Records from DB->XML/JSON
	@GetMapping("/all")
	public ResponseEntity<?>getAll(){
		ResponseEntity<?>message=null;
		List<Uom>uoms=service.getAllUom();
		if(uoms==null || uoms.isEmpty()) {
			//data not available
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
		}
		else {
			//data exist
			message=new ResponseEntity<List<Uom>>(uoms,HttpStatus.OK);//200
		}
		return message;
	}
	//2.Get one object by id 
	@GetMapping("/get/{id}")
	public ResponseEntity<?>getOne(@PathVariable Integer id){
		ResponseEntity<?> message=null;
		Uom uom=service.getOneUomById(id);
		if(uom==null) {
			//not data found
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
		}
		else {
			//data exist
			message=new ResponseEntity<Uom>(uom,HttpStatus.OK);//200
		}
		return message;
	}
	//3.Delete Data 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		ResponseEntity<String> message=null;
		try {
			service.deleteUom(id);
			message=new ResponseEntity<String>("Uom deleted Successfully",HttpStatus.OK);
		}
		catch(Exception e) {
			message=new ResponseEntity<String>("Uom Not found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	//4.save data into DB
	@PostMapping("/save")
	public ResponseEntity<String>save(@PathVariable Uom uom){
		ResponseEntity<String> message=null;
		try {
			Integer id=service.saveUom(uom);
			message=new ResponseEntity<String>("save with id:"+id,HttpStatus.OK);
		}
		catch(Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	//5.update data 
	@PutMapping("/update")
	public  ResponseEntity<String> update(@RequestBody Uom uom){
		ResponseEntity<String> message=null;
		try {
			service.updateUom(uom);
			message=new ResponseEntity<String>("Uom updated",HttpStatus.OK);
		}
		catch(Exception e) {
			message=new ResponseEntity<String>("Uom'"+uom.getUid()+"'Not found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}

}
