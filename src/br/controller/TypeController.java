package br.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.model.Collection;
import br.model.Type;
import br.model.User;
import br.util.Util;

public class TypeController extends BaseController {
	
	public TypeController(){
		super();
	}
	
	public List<Type> lista(){
		List<Type> types = new ArrayList<Type>();
		
		setSql("select * from type");
		
		ResultSet rs = list();
		
		if(rs != null){
			try {
				while(rs.next()){
					types.add(new Type(rs.getInt("id"), 
							rs.getString("name"),
							rs.getString("description")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		return types;
	}

}
