package edu.vinaenter.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Category {

	private int cid;

	@NotEmpty()
	@Size(min=3, max =30, message = "name category min=3 and max = 30")
	private String cname;
	
	private int num;

	public Category(int id, String name) {
		super();
		this.cid = id;
		this.cname = name;
	}

}
