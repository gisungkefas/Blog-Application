package com.kefas.blogapplicationweeknine.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long userId;

	private String firstname;

	private String lastname;

//	@Email
	private String email;

	private String phoneNumber;

	private String password;

}
