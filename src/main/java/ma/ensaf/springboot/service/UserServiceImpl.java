package ma.ensaf.springboot.service;

import java.util.List;
import java.util.Optional;

import ma.ensaf.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensaf.springboot.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}
	@Override
	public void addUser(User user) {
		this.userRepository.save(user);
		
	}
	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}else {
			throw new RuntimeException("User not found for id :: "+id);
		}
		return user;
	}

	public void deleteUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()){
		this.userRepository.deleteById(id);}
		else {
			throw new RuntimeException("User not found for id :: "+id);
		}
		
	}

	@Override
	public String save(User user) {
		return userRepository.save(user).toString();
	}


}
