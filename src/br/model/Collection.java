package br.model;

import org.primefaces.model.UploadedFile;

public class Collection {
	
	private int id;
	private int iduser;
	private String name;
	private String description;
	private String picture;
	private UploadedFile filePicture;
	private int editions;
	private int type;
	private int publishingCompany;
	private Boolean status;
	private Boolean accessType;
	
	public Collection(){
		
	}
	
	public Collection(int id, int iduser, String name, String description, String picture, int editions, int type,
			int publishingCompany, Boolean status, Boolean accessType, UploadedFile filePicture) {
		super();
		this.id = id;
		this.iduser = iduser;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.editions = editions;
		this.type = type;
		this.publishingCompany = publishingCompany;
		this.status = status;
		this.accessType = accessType;
		this.filePicture = filePicture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return iduser;
	}

	public void setIdUser(int iduser) {
		this.iduser = iduser;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getEditions() {
		return editions;
	}

	public void setEditions(int editions) {
		this.editions = editions;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(int publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getAccessType() {
		return accessType;
	}

	public void setAccessType(Boolean accessType) {
		this.accessType = accessType;
	}

	public UploadedFile getFilePicture() {
		return filePicture;
	}

	public void setFilePicture(UploadedFile filePicture) {
		this.filePicture = filePicture;
	}
}
