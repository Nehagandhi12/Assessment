package com.example.Dao;

//Dao for Validation
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bean.ValidateBean;
import com.example.Repositories.Crud;
import com.example.Repositories.CrudAdmin;
import com.example.Repositories.CrudValidationInterface;

@Service
public class ValidateDao implements CrudValidationInterface {

	@Autowired
	private Crud crud;

	@Autowired
	private CrudAdmin crudadmin;

	@Override
	// Returns role after validating id and password
	public String validatetheperson(ValidateBean validate) {
		// TODO Auto-generated method stub

		Optional<ValidateBean> list = crud.findById(validate.getId());

		if (list.get().getPassword().equals(validate.getPassword())) {
			String role = list.get().getRole();
			if (role.equals("admin")) {
				int result = crudadmin.validateperson(validate.getId());
				if (result == 1) {
					role = "manager";
				}
			}
			return role;
		}

		return "error";
	}

}
