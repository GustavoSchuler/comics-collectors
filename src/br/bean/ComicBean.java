package br.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.controller.CollectionController;
import br.controller.ComicController;
import br.controller.StateController;
import br.model.Collection;
import br.model.Comic;
import br.model.State;
import br.util.Util;

@ManagedBean
@ViewScoped
public class ComicBean {
	
	private Comic comic;
	private List<Collection> collections;
	private List<State> states;
	
	public ComicBean(){
		
		CollectionController collectionController = new CollectionController();
		this.collections = collectionController.lista();
		
		StateController stateController = new StateController();
		this.states = stateController.listar();
		
		if(Util.getSession().getAttribute("comic") != null){
			
			this.comic = ( (Comic)Util.getSession().getAttribute("comic") );
			
		}else{
		
			this.comic = new Comic(0,0,"",0,"",0.0,0,null,0);
			
		}
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}
	
	public void salvar(){
		ComicController ctrl = new ComicController(comic);
		
		if(comic.getId() == 0){
			ctrl.insere();
		}else{
			ctrl.atualiza();
		}
		
		goListaComic();
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

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	public String goCadastroComic(Comic comic){
		//Caso venha algum comic por parâmetro, adiciona na sessão. Isso indica que é uma edição.
		if(comic != null){
			Util.getSession().setAttribute("comic", comic);
		}
		
		return "cadastro-comic";

	}
	
	public String goListaComic(){
		Util.getSession().setAttribute("comic", null);
		return "lista-comic";
	}
	
}
