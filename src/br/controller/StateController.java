package br.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.model.State;

public class StateController extends BaseController{
	
	public List<State> listar(){
		
		List<State> states = new ArrayList<State>();
		
		setSql("select * from state");
		
		ResultSet rs = list();
		
		if(rs != null){
			try {
				while(rs.next()){
					states.add(new State(rs.getInt("id"), 
							rs.getString("name"),
							rs.getString("description")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		return states;
		
	}

}
