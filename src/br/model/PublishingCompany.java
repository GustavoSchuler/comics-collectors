package br.model;

public class PublishingCompany {
	
	private int id;
	private String name;
	private String description;
	private String logo;
	
	public PublishingCompany(){
		super();
	}
	
	public PublishingCompany(int id, String name, String description, String logo) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.logo = logo;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}

}
