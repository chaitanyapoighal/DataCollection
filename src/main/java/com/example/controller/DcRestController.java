package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Dc_Cases;
//import com.example.entity.Dc_Cases;
import com.example.entity.Dc_Children;
import com.example.entity.Dc_Education;
import com.example.entity.Dc_Income;
import com.example.service.ServiceRepo;

@RestController
public class DcRestController {
	@Autowired
	ServiceRepo serv;

	@GetMapping("/search/{id}")
	public ResponseEntity<Integer> getnum(@PathVariable("id") Integer id) {
		Integer caseno = serv.search(id);
		return new ResponseEntity<>(caseno, HttpStatus.OK);
	}
  
	@GetMapping("/plans")
	public ResponseEntity<Map<Integer, String>> getplansdc()
	{
		Map<Integer, String> plans=serv.getplans();
		return new ResponseEntity<>(plans, HttpStatus.OK);
	}
	
	@PutMapping("/saveplan/{cno}/{apid}/{planname}")
	public ResponseEntity<String> getplansave(@RequestBody Dc_Cases dccase,@PathVariable("cno") Integer cno,@PathVariable("apid") Integer apid,@PathVariable("planname") String planname)
	{   
		String str;
		Integer value=serv.selectplan(cno, apid, planname);
		if(value>0)
			str="Successfully stored";
		else
			str="Failure";
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
	
	@PutMapping("/income/{id}")
	public ResponseEntity<String> getincomesave(@RequestBody Dc_Income dcinc,@PathVariable("Id") Integer id)
	{
		String str=serv.saveIncome(dcinc, id);
		return new ResponseEntity<>(str,HttpStatus.OK);
		
	}
	
	@PutMapping("/education/{id}")
	public ResponseEntity<String> getEducationsave(@RequestBody Dc_Education dcedu,@PathVariable("Id") Integer id)
	{
		String str=serv.saveEducation(dcedu, id);
		return new ResponseEntity<>(str,HttpStatus.OK);
	}
	
	@PutMapping("/children/{id}")
	public ResponseEntity<String> getchildrensave(@RequestBody Dc_Children dcedu,@PathVariable("Id") Integer id)
	{
		
		
		serv.saveChildren(dcedu, id);

		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	
}
