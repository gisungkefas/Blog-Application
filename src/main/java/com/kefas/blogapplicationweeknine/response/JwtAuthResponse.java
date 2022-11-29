package com.kefas.blogapplicationweeknine.response;

import com.kefas.blogapplicationweeknine.dto.UserDto;
import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	
	private UserDto user;
}
