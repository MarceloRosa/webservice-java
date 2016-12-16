package br.unifor.pin.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.pin.webservice.model.Login;
import br.unifor.pin.webservice.model.User;
import br.unifor.pin.webservice.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(
			value = "/login", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User hello(@RequestBody Login login) {
		
		if(login.getEmail() != null && login.getPassword() != null){
			User user = userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
			if(user != null){
				return user;
			} else {
				return null;
			}
		}
		
		return null;
	}

}
