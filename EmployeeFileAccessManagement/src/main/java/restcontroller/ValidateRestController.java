package restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.Validate;
import service.ValidateService;

@RestController
@RequestMapping("valid")
public class ValidateRestController {

	@Autowired
	ValidateService validatedao;

	@GetMapping("/request/{id}/{password}")

	public String get(@PathVariable("id") int id,@PathVariable("password") String password) {
        Validate validate=new Validate();
        validate.setId(id);
        validate.setPassword(password);
		String result = validatedao.validatetheperson(validate);
		return result;
	}
}
