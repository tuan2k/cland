package edu.vinaenter.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Land {
	
	private int lid;
	
	private String lname;
	
	private String description;
	
	private String date;
	
	private int cat_id;
	
	private String picture;
	
	private int area;
	
	private String address;
	
	private int count_views;

	public Land(int id, String name, String description, String date, int cat_id, String picture, int area,
			String address, int count_views) {
		super();
		this.lid = id;
		this.lname = name;
		this.description = description;
		this.date = date;
		this.cat_id = cat_id;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.count_views = count_views;
	}
	
}
