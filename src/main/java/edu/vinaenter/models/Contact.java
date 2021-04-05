package edu.vinaenter.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Contact {
	
	private int cid;
	
	private String fullname;
	
	private String email;
	
	private String subject ;
	
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
