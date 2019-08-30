package com.example.AllControllers;
//ValidateController calls ValidateRestController to validate logged in person
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bean.ValidateBean;
import com.example.Business.ValidateBusiness;


@RestController
@RequestMapping("valid")
//RestController for Validating logged in person
public class ValidateRestController {
	
	@Autowired
	ValidateBusiness validate;

	@RequestMapping("/request")
	// Calls ValidateBusiness function to validate logged in person
	public String get(@RequestBody ValidateBean data) {
	
         
		String result = validate.validateperson(data);
		return result;
	}
}
