package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Validate;
import repository.RAdmin;
import repository.RValidation;

@Service
public class ValidateService {

	@Autowired
	private RValidation crud;
	@Autowired
	private RAdmin crudadmin;

	public String validatetheperson(Validate validate) {
		// TODO Auto-generated method stub

		Optional<Validate> list = crud.findById(validate.getId());
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
