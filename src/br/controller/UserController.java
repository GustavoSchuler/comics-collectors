package br.controller;

import java.sql.ResultSet;

import br.model.User;

public class UserController extends BaseController {
	
	private User user;
	
	public UserController(){
		super();
	}
	
	public UserController(User user){
		super();
		this.user = user;	
	}
	
	public void atualiza(){
		StringBuffer sql = new StringBuffer();
		
		sql.append("update users ");
		sql.append("   set name = ?,");
		sql.append("       email = ?,");
		sql.append("       password = ?,");
		sql.append(" where id = ?) ");
		
		setSql(sql.toString());
		
		Object[] sqlParams = {
				user.getName(),
				user.getEmail(),
				user.getPassword(),
				user.getId()
		};
		
		setSqlParams(sqlParams);
		
		executaUpdate();
	}
	
}
