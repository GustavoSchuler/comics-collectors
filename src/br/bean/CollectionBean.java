package br.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.controller.CollectionController;
import br.controller.PublishingCompanyController;
import br.model.Collection;
import br.model.PublishingCompany;

@ManagedBean
@ViewScoped
public class CollectionBean {
	
	private Collection collection;
	private List<PublishingCompany> listaCompany;
	
	public CollectionBean(){
		this.collection = new Collection();
		
		PublishingCompanyController ctrl = new PublishingCompanyController();
		this.listaCompany = ctrl.lista();
	}
	
	public void inserir(){
		CollectionController ctrl = new CollectionController(collection);
		ctrl.insere();
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
		return "cadastro-collection";
	}

	public List<PublishingCompany> getListaCompany() {
		return listaCompany;
	}

	public void setListaCompany(List<PublishingCompany> listaCompany) {
		this.listaCompany = listaCompany;
	}

}