package br.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.util.Util;

@ManagedBean
@SessionScoped
public class IndexBean {
	
	private void go(String onde){
		try {
			Util.sendRedirect(onde);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void goComic(){
		go("./lista-comic.jsf");
	}
	
	public void goCollection(){
		go("./lista-collection.jsf");
	}
	
	public void goCompany(){
		go("./lista-company.jsf");
	}
	
	public void goType(){
		go("./lista-type.jsf");
	}	
	
	public void goUser(){
		go("./lista-user.jsf");
	}
}
