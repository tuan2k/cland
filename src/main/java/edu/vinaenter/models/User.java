package edu.vinaenter.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class User {
	
	private int id;
	
	@NotEmpty
	@Size(min=5 , max = 20,message ="username must be at least 5 character and max 20 character" )
	private String username;
	
	@NotEmpty
	@Size(min=5 , max = 50)
	private String fullname;
	
	@NotEmpty
	@Size(min=6 , max = 40)
	private String password;
	
	private String token;

	public User(int id, String username, String fullname, String password, String token) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.token = token;
	}
}
