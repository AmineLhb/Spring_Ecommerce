package ma.ensaf.springboot.controller;

import ma.ensaf.springboot.model.User;
import ma.ensaf.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	//display list of users
	@GetMapping("/users")
	@ResponseBody
	private List<User> getUsers(){
		return userService.getAllUsers();
	}
	//display users by id
	@GetMapping("/users/{id}")
	@ResponseBody
	public User getuser(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
	//register
	@PostMapping("/register")
	@ResponseBody
	public String addUser(@RequestBody User user) {
		user.setRole("visitor");
		System.out.println(user);
		return userService.save(user);
	}

	//update user
	@PutMapping("/showFormForUpdate/{id}")
	@ResponseBody
	public String showFormForUpdate(@PathVariable (value = "id") Long id, @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
		User user = userService.getUserById(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setEmail(email);
		return userService.save(user);
	}
	//delete user by id
	@DeleteMapping("/deleteUser/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable (value = "id") Long id) {
			this.userService.deleteUserById(id);
	}
	//update to user
	@PutMapping("/updatetoUser/{id}")
	@ResponseBody
	public String updatetoUser(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		user.setRole("user");
		System.out.println(user);
		return userService.save(user);

	}
}


