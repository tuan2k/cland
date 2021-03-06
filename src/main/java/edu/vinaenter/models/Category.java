package edu.vinaenter.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Category {

	private int cid;

	private String cname;

	public Category(int id, String name) {
		super();
		this.cid = id;
		this.cname = name;
	}

}
