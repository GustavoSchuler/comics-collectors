package br.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class IndexBean {
	
	public String goIndex(){
		return "success";
	}
	
	public String goComic(){
		return "lista-comic";
	}
	
	public String goCollection(){
		return "lista-collection";
	}
	
	public String goCompany(){
		return "lista-company";
	}
	
	public String goType(){
		return "lista-type";
	}	
	
	public String goUser(){
		return "user-edit";
	}
}
