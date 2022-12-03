package com.kefas.blogapplicationweeknine.controllers;

import com.kefas.blogapplicationweeknine.dto.UserDto;
import com.kefas.blogapplicationweeknine.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.ACCEPTED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody UserDto userDto){
		return new ResponseEntity<>(userService.userLogin(userDto), HttpStatus.ACCEPTED);
	}
}