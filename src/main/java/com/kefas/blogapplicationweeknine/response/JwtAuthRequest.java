package com.kefas.blogapplicationweeknine.response;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String username;
	
	private String password;
	
}
