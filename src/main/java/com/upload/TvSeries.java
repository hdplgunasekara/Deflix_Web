package com.upload;

public class TvSeries  {
	int id;
	String name;
	String language;	
	int year;
	int rating;
	int season;
	int episode;
	String link;
	String filename;
	String path;

	public TvSeries() {
		// TODO Auto-generated constructor stub
	}
	
	public TvSeries(int id, String name, String language, int year, int rating, int season, int episode, String link,
			String filename, String path) {
	
		this.id = id;
		this.name = name;
		this.language = language;
		this.year = year;
		this.rating = rating;
		this.season = season;
		this.episode = episode;
		this.link = link;
		this.filename = filename;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	public int getYear() {
		return year;
	}

	public int getRating() {
		return rating;
	}

	public int getSeason() {
		return season;
	}

	public int getEpisode() {
		return episode;
	}

	public String getLink() {
		return link;
	}

	public String getFilename() {
		return filename;
	}

	public String getPath() {
		return path;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setPath(String path) {
		this.path = path;
	}


	

}
