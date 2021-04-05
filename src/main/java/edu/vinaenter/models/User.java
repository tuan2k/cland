package edu.vinaenter.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class User {
	
	private int id;
	
	private String username;
	
	private String fullname;
	
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
