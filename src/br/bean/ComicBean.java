package br.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.controller.CollectionController;
import br.controller.ComicController;
import br.model.Collection;
import br.model.Comic;

@ManagedBean
@ViewScoped
public class ComicBean {
	
	private Comic comic;
	private List<Collection> collections;
	
	public ComicBean(){
		this.comic = new Comic(0,0,"",0,"",0.0,0,null,0);
		
		CollectionController collectionController = new CollectionController();
		this.collections = collectionController.lista();
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}
	
	public void inserir(){
		ComicController ctrl = new ComicController(comic);
		ctrl.insere();
		System.out.println("Inseriu");
	}
	
	public void salvar(){
		
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	
	public List<Comic> getListaComicsUser(){
		ComicController ctrl = new ComicController();
		List<Comic> listaComic = ctrl.lista(); 
		
		return listaComic;
	}
}
