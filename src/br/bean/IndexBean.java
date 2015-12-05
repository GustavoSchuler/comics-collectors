package br.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.controller.HomeController;
import br.model.Collection;


@ManagedBean
@SessionScoped
public class IndexBean {
	
	private List<Collection> listaColecoesPublicas;
	
	public IndexBean(){
		HomeController ctrl = new HomeController();
		this.listaColecoesPublicas = ctrl.getTodasColecoes();
	}
	
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

	public List<Collection> getListaColecoesPublicas() {
		return listaColecoesPublicas;
	}

	public void setListaColecoesPublicas(List<Collection> listaColecoesPublicas) {
		this.listaColecoesPublicas = listaColecoesPublicas;
	}
}
