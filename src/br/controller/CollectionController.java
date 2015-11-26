package br.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.model.Collection;

public class CollectionController extends BaseController {
	
	Collection collection;
	
	public CollectionController(){
		super();
	}
	
	public CollectionController(Collection collection){
		super();
		this.collection = collection;	
	}
	
	public void insere(){
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into collection (");
		sql.append("iduser,");
		sql.append("name,");
		sql.append("description,");
		sql.append("picture,");
		sql.append("editions,");
		sql.append("type,");
		sql.append("publishing_company,");
		sql.append("status,");
		sql.append("access_type");
		sql.append(") values (?,?,?,?,?,?,?,?,?)");
		
		setSql(sql.toString());
		
		Object[] sqlParams = {
				2, //collection.getIdUser(),
				collection.getName(),
				collection.getDescription(),
				collection.getPicture(),
				collection.getEditions(),
				collection.getType(),
				collection.getPublishingCompany(),
				collection.getStatus(),
				collection.getAccessType()
		};
		
		setSqlParams(sqlParams);
		
		executaInsert();
	}
	
	public List<Collection> lista(){
		List<Collection> collections = new ArrayList<Collection>();
		
		setSql("select * from collection");
		
		ResultSet rs = list();
		
		if(rs != null){
			try {
				while(rs.next()){
					collections.add(new Collection(rs.getInt("id"), 
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
				return null;
			}
		}
		
		return collections;
	}

}
