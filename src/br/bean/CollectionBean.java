package br.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.controller.CollectionController;
import br.controller.PublishingCompanyController;
import br.model.Collection;
import br.model.PublishingCompany;
import br.util.Util;

@ManagedBean
@ViewScoped
public class CollectionBean {
	
	private Collection collection;
	private List<PublishingCompany> listaCompany;
	
	public CollectionBean(){
		this.collection = new Collection();
		
		PublishingCompanyController ctrl = new PublishingCompanyController();
		this.listaCompany = ctrl.lista();
		
		if(Util.getSession().getAttribute("collection") != null){
			
			this.collection = ( (Collection)Util.getSession().getAttribute("collection") );
			
		}else{
		
			this.collection = new Collection();
			
		}
	}
	
	public void salvar(){
		CollectionController ctrl = new CollectionController(collection);
		
		if(collection.getId() == 0){
			ctrl.insere();
		}else{
			ctrl.atualiza();
		}
		
		goListaCollection();
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	
	public List<Collection> getListaCollectionUser(){
		CollectionController ctrl = new CollectionController();
		List<Collection> listaCollection = ctrl.lista(); 
		
		return listaCollection;
	}
	
	public void deletar(Collection collection){
		CollectionController ctrl = new CollectionController(collection);
		ctrl.deleta();
	}

	public String goNewCollection(){
		Util.getSession().setAttribute("collection", null);
		return "cadastro-collection";
	}

	public List<PublishingCompany> getListaCompany() {
		return listaCompany;
	}

	public void setListaCompany(List<PublishingCompany> listaCompany) {
		this.listaCompany = listaCompany;
	}
	
	public String goCadastroCollection(Collection collection){
		//Caso venha algum collection por parâmetro, adiciona na sessão. Isso indica que é uma edição.
		if(collection != null){
			Util.getSession().setAttribute("collection", collection);
		}
		
		return "cadastro-collection";

	}
	
	public String goListaCollection(){
		Util.getSession().setAttribute("collection", null);
		return "lista-collection";
	}

}