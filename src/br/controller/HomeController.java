package br.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.model.Collection;

public class HomeController extends BaseController {
	
	private List<Collection> todasColecoes;
	
	public HomeController(){
		this.todasColecoes = new ArrayList<Collection>();
		
		String sql = "select c.* " + 
		             "  from users_collection uc, " +
				     "       collection c " +
				     " where uc.collection = c.collection ";
		
		setSql(sql);
		
		ResultSet rs = list();
		
		if(rs != null){
			try {
				while(rs.next()){
					todasColecoes.add(new Collection(rs.getInt("id"), 
							rs.getInt("iduser"),
							rs.getString("name"),
							rs.getString("description"),
							rs.getString("picture"),
							rs.getInt("editions"),
							rs.getInt("type"),
							rs.getInt("publishing_company"),
							rs.getBoolean("status"),
							rs.getBoolean("access_type")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Collection> getTodasColecoes() {
		return todasColecoes;
	}

	public void setTodasColecoes(List<Collection> todasColecoes) {
		this.todasColecoes = todasColecoes;
	}

}
