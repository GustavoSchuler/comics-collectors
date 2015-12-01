package br.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.model.PublishingCompany;

public class PublishingCompanyController extends BaseController {
	
	private PublishingCompany publishingCompany;
	
	public PublishingCompanyController(){
		super();
	}
	
	public PublishingCompanyController(PublishingCompany publishingCompany){
		this.publishingCompany = publishingCompany;
	}
	
	public void insere(){
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into publishing_company (");
		sql.append("name,");
		sql.append("description,");
		sql.append("logo");
		sql.append(") values (?,?,?)");
		
		setSql(sql.toString()); 
		
		Object[] sqlParams = {
				publishingCompany.getName(),
				publishingCompany.getDescription(),
				publishingCompany.getLogo()
		};
		
		setSqlParams(sqlParams);
		
		executaInsert();
	}
	
	public List<PublishingCompany> lista(){
		List<PublishingCompany> publishingCompany = new ArrayList<PublishingCompany>();
		
		setSql("select * from publishing_company");
		
		ResultSet rs = list();
		
		if(rs != null){
			try {
				while(rs.next()){
					publishingCompany.add(new PublishingCompany(rs.getInt("id"), 
							rs.getString("name"),
							rs.getString("description"),
							rs.getString("logo")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		return publishingCompany;
	}
	
	public void deleta(){
		setSql("delete from publishing_company where id = ?");
		
		Object[] sqlParams = {
				publishingCompany.getId()
		};
		
		setSqlParams(sqlParams);
		executaDelete();
	}
	
	public void atualiza(){
		StringBuffer sql = new StringBuffer();
		
		sql.append("update publishing_company ");
		sql.append("   set name = ?,");
		sql.append("       description = ?,");
		sql.append("       logo = ?");
		sql.append(" where id = ? ");
		
		setSql(sql.toString());
		
		Object[] sqlParams = {
				publishingCompany.getName(),
				publishingCompany.getDescription(),
				publishingCompany.getLogo(),
				publishingCompany.getId()
		};
		
		setSqlParams(sqlParams);
		
		executaUpdate();
	}

}
