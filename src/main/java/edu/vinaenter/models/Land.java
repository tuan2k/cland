package edu.vinaenter.models;

import org.springframework.web.multipart.MultipartFile;

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
	
	private Category category;
	
	private MultipartFile picture;
	
	private String pictures;
	
	private int area;
	
	private String address;
	
	private int count_views;

	public Land(int id, String name, String description, String date, Category category, MultipartFile picture, int area,
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
