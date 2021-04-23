package edu.vinaenter.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Contact {
	
	private int cid;
	
	@NotEmpty
	@Size(min = 5, max=20)
	private String fullname;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Size(min =4, max =30)
	private String subject ;
	
	@NotEmpty
	@Size(min = 10)
	private String content;

	public Contact(int id, String fullname, String email, String subject, String content) {
		super();
		this.cid = id;
		this.fullname = fullname;
		this.email = email;
		this.subject = subject;
		this.content = content;
	}
	
	

}
