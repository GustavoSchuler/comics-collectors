package br.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.controller.UserController;
import br.model.Comic;
import br.model.User;

@ManagedBean
@ViewScoped
public class UserBean {

	private User user;
	
	public UserBean() {
		this.user = new User();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void salvar(){
		
		UserController ctrl = new UserController(user);
		
		ctrl.atualiza();
		
	}
	
}
