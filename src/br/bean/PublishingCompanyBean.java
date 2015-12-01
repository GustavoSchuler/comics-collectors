package br.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.controller.PublishingCompanyController;
import br.model.PublishingCompany;
import br.util.Util;

@ManagedBean
@ViewScoped
public class PublishingCompanyBean {
	
	private PublishingCompany publishingCompany;

	public PublishingCompanyBean() {
		
		if(Util.getSession().getAttribute("publishingCompany") != null){
			
			this.publishingCompany = ( (PublishingCompany)Util.getSession().getAttribute("publishingCompany") );
			
		}else{
		
			this.publishingCompany = new PublishingCompany();
			
		}
	}

	public PublishingCompany getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(PublishingCompany publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	
	public String goNewCompany(){
		return "cadastro-company";
	}
	
	public String goUpdateCompany(PublishingCompany publishingCompany){
		//Caso venha algum PublishingCompany por parâmetro, adiciona na sessão. Isso indica que é uma edição.
		if(publishingCompany != null){
			Util.getSession().setAttribute("publishingCompany", publishingCompany);
		}
		
		return "cadastro-company";
	}
	
	public String goListaPublishingCompany(){
		Util.getSession().setAttribute("publishingCompany", null);
		
		return "lista-company";
	}
	
	public List<PublishingCompany> getListaPublishingCompany(){
		PublishingCompanyController ctrl = new PublishingCompanyController();
		List<PublishingCompany> listaPublishingCompany = ctrl.lista();
		
		return listaPublishingCompany;
	}
	
	public void salvar(){
		PublishingCompanyController ctrl = new PublishingCompanyController(publishingCompany);
		
		if(publishingCompany.getId() == 0){
			ctrl.insere();
		}else{
			ctrl.atualiza();
		}
		
		goListaPublishingCompany();
	}
	
	public void deletar(PublishingCompany publishingCompany){
		PublishingCompanyController ctrl = new PublishingCompanyController(publishingCompany);
		ctrl.deleta();
	}

}
