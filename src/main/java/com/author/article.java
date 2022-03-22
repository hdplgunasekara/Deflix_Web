package com.author;

public class article {
	private int ID;
	private String name;
	private int rating;
	private String category;
	private String description;
	
	public article(int iD, String name, int rating, String category, String description) {
		
		ID = iD;
		this.name = name;
		this.rating = rating;
		this.category = category;
		this.description = description;
	}

	public int getID() {
		return ID;
	}

	
	public String getName() {
		return name;
	}

	

	public int getRating() {
		return rating;
	}


	public String getCategory() {
		return category;
	}

	
	public String getDescription() {
		return description;
	}


	
}
