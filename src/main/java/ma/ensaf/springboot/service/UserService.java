package ma.ensaf.springboot.service;

import java.util.List;
import java.util.Optional;

import ma.ensaf.springboot.model.User;

public interface UserService {
	List<User> getAllUsers();
	User getUserById(long id);
	void deleteUserById(long id);
	String save(User user);

	void addUser(User user);

}
