package com.kefas.blogapplicationweeknine.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	@NotBlank(message = "First Name should not be Empty")
	private String firstname;

	@NotBlank(message = "Last Name should not be Empty")
	private String lastname;

	@NotBlank(message = "Email not Valid")
	private String email;

	@NotBlank(message = "Phone Number should not be Empty")
	private String phoneNumber;

	@NotBlank(message = "Password should not be Empty")
	private String password;

}
