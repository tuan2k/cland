package edu.vinaenter.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Land {
	
	private int lid;
	
	@NotEmpty
	@Size(min =3,max =30)
	private String lname;
	
	@NotEmpty
	@Size(min = 10)
	private String description;
	
	private String date;
	
	private Category category;
	
	private String picture;
	
	private int area;
	
	@NotEmpty
	@Size(min = 10, max = 100)
	private String address;
	
	private int count_views;

	public Land(int id, String name, String description, String date, Category category, String picture, int area,
			String address, int count_views) {
		super();
		this.lid = id;
		this.lname = name;
		this.description = description;
		this.date = date;
		this.category = category;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.count_views = count_views;
	}

	
}
