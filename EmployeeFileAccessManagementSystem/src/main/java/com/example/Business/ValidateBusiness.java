package com.example.Business;

//Business Class For Validating logged In Person
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bean.ValidateBean;
import com.example.Dao.ValidateDao;

@Service
public class ValidateBusiness {

	@Autowired
	ValidateDao validate;

	// Calls ValidateDao Function to validate logged in person
	public String validateperson(ValidateBean data) {

		String role = validate.validatetheperson(data);
		return role;

	}
}
