package com.kefas.blogapplicationweeknine.services.impl;

import com.kefas.blogapplicationweeknine.dto.UserDto;
import com.kefas.blogapplicationweeknine.entities.User;
import com.kefas.blogapplicationweeknine.exceptions.UserAlreadyExistException;
import com.kefas.blogapplicationweeknine.exceptions.UserNotFoundException;
import com.kefas.blogapplicationweeknine.repositories.UserRepository;
import com.kefas.blogapplicationweeknine.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;


	@Override
	public UserDto createUser(UserDto userDto) {
		User users = new User();
		boolean existUser = this.userRepository.findUserByEmail(userDto.getEmail()).isPresent();
		if(existUser){
			throw new UserAlreadyExistException("User with "+userDto.getEmail()+"Already Exist");
		}
		users.setFirstname(userDto.getFirstname());
		users.setLastname(userDto.getLastname());
		users.setEmail(userDto.getEmail());
		users.setPhoneNumber(userDto.getPhoneNumber());
		users.setPassword(userDto.getPassword());
		userRepository.save(users);

		return userDto;
	}

	@Override
	public String userLogin(UserDto usersDto) {
		User user = userRepository.findByEmailAndPassword(usersDto.getEmail(), usersDto.getPassword());
		if(user == null){
			throw new UserNotFoundException("Fill out the required fields");
		}
		if(!Objects.equals(user.getPassword(), usersDto.getPassword()) || !Objects.equals(user.getEmail(), usersDto.getEmail())){
			return "Invalid Email or Password";
		}
		return "Login Successfully";
	}
}
