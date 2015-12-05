package br.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.controller.CollectionController;
import br.controller.ComicController;
import br.controller.StateController;
import br.model.Collection;
import br.model.Comic;
import br.model.State;
import br.util.MeuListener;
import br.util.Util;

@ManagedBean
@ViewScoped
public class ComicBean {
	
	private Comic comic;
	private List<Collection> collections;
	private List<State> states;
	private Collection selectedCollection;
	
	public ComicBean(){
		
		CollectionController collectionController = new CollectionController();
		this.collections = collectionController.lista();
		
		StateController stateController = new StateController();
		this.states = stateController.listar();
		
		this.selectedCollection = (Collection) Util.getSession().getAttribute("selected-collection");
		
		if(Util.getSession().getAttribute("comic") != null){
			
			this.comic = ( (Comic)Util.getSession().getAttribute("comic") );
			
		}else{
		
			this.comic = new Comic();
			this.comic.setCollection(this.selectedCollection.getId());
			
		}
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}
	
	public void salvar(){
		
		if(comic.getFilePicture() != null){
			//salva imagem
			String newFilePath = MeuListener.getCaminhoImagens();
			String nomeImagem = Util.salvaImagem(comic.getFilePicture(), newFilePath);
			comic.setPicture(nomeImagem);
		}
		
		ComicController ctrl = new ComicController(comic);
		
		if(comic.getId() == 0){
			ctrl.insere();
		}else{
			ctrl.atualiza();
		}
		
		FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Sucesso",  "O quadrinho foi salvo!") );
	}

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	
	public List<Comic> getListaComicsUser(){
		ComicController ctrl = new ComicController();
		List<Comic> listaComic = ctrl.lista(selectedCollection); 
		
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
