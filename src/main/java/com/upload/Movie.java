package com.upload;

public class Movie {
    private int Id;
	private String Name;
	private String Link;
	private String Language;
	private String Filename;
	private String Path;
	private int Year;
	private int Rating;
	
	public Movie() {
		
	}
	
	public Movie(int id, String name, String link, String description,String filename,String path,int year,int rating) {
		
		this.Id = id;
		this.Name = name;
		this.Link = link;
		this.Language = description;
		this.Filename=filename;
		this.Path=path;
		this.Year=year;
		this.Rating=rating;
				
	}
	public int getYear() {
		return Year;
	}

	public int getRating() {
		return Rating;
	}

	public String getName() {
		return Name;
	}
	public String getLanguage() {
		return Language;
	}
	public String getLink() {
		return Link;
	}
	public int getId() {
		return Id;
	}
	public String getFilename() {
		return Filename;
	}

	public String getPath() {
		return Path;
	}

	
	
}
