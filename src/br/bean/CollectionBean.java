package br.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.controller.CollectionController;
import br.model.Collection;

@ManagedBean
@ViewScoped
public class CollectionBean {
	
	private Collection collection;
	
	public CollectionBean(){
		this.collection = new Collection();
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

}