package com.upload;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String subject;
	private String message;
	public Contact(int id, String name,String email, String subject, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email=email;
		this.subject = subject;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSubject() {
		return subject;
	}
	public String getMessage() {
		return message;
	}
	public String getEmail() {
		return email;
	}

}
