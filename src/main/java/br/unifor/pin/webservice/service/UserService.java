package br.unifor.pin.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.pin.webservice.model.Response;
import br.unifor.pin.webservice.model.Response.Status;
import br.unifor.pin.webservice.model.User;
import br.unifor.pin.webservice.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(
			method = {RequestMethod.POST, RequestMethod.PUT},
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response saveUser(@RequestBody User user){
		
		if(user.getName() != null && user.getEmail() != null && user.getPassword() != null){
		
			if(userRepository.saveAndFlush(user) != null){
				return new Response(Status.OK, "User sucessfully saved.");
			} else {
				return new Response(Status.ERROR, "An error occurred during the user save process.");
			}
			
		} else {
			return new Response(Status.ERROR, "Incomplete or wrong information about the user");
		}
		
		
	}
	
	@RequestMapping(
			value="/{id}",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response delete(@PathVariable("id") Long id){
		
		if(userRepository.exists(id)){
			userRepository.delete(id);
			return new Response(Status.OK, "User sucessfully deleted.");
		} else {
			return new Response(Status.ERROR, "There isn't a user with id " + id);
		}
		
	}
	
	@RequestMapping(
			value="/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User findUser(@PathVariable Long id){
		return userRepository.findOne(id);
	}
	
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> findAllUser(){
		return userRepository.findAll();
	}

}
