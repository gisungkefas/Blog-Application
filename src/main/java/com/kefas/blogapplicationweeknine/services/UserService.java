package com.kefas.blogapplicationweeknine.services;

import com.kefas.blogapplicationweeknine.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	String userLogin (UserDto usersDto);

}
