package br.model;

import org.primefaces.model.UploadedFile;

public class Comic {
	
	private int id;
	private int collection;
	private String title;
	private int number;
	private String picture;
	private UploadedFile filePicture;
	private double price;
	private int state;
	private Boolean readed;
	private int grade;
	
	public Comic(){}
	
	public Comic(int id, int collection, String title, int number, String picture, double price, int state, Boolean readed,
			int grade, UploadedFile filePicture) {
		super();
		this.id = id;
		this.collection = collection;
		this.title = title;
		this.number = number;
		this.picture = picture;
		this.price = price;
		this.state = state;
		this.readed = readed;
		this.grade = grade;
		this.filePicture = filePicture;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCollection() {
		return collection;
	}
	public void setCollection(int collection) {
		this.collection = collection;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Boolean getReaded() {
		return readed;
	}
	public void setReaded(Boolean readed) {
		this.readed = readed;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public UploadedFile getFilePicture() {
		return filePicture;
	}

	public void setFilePicture(UploadedFile filePicture) {
		this.filePicture = filePicture;
	}
	
}
