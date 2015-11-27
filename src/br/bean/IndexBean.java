package br.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.util.Util;

@ManagedBean
@SessionScoped
public class IndexBean {
	
	public String goComic(){
		return "lista-comic";
	}
	
	public String goCollection() throws IOException{
		return "lista-collection";
	}
	
	public String goCompany(){
		return "lista-company";
	}
	
	public String goType(){
		return "lista-type";
	}	
	
	public String goUser(){
		return "lista-user";
	}
}
