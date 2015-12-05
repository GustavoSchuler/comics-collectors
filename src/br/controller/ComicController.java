package br.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.model.Collection;
import br.model.Comic;

public class ComicController extends BaseController {
	
	private Comic comic;
	
	public ComicController(){
		super();
	}
	
	public ComicController(Comic comic){
		super();
		this.comic = comic;	
	}
	
	public void insere(){
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into comic (");
		sql.append("collection,");
		sql.append("title,");
		sql.append("number,");
		sql.append("picture,");
		sql.append("price,");
		sql.append("state,");
		sql.append("readed,");
		sql.append("grade");
		sql.append(") values (?,?,?,?,?,?,?,?)");
		
		setSql(sql.toString());
		
		Object[] sqlParams = {
				comic.getCollection(),
				comic.getTitle(),
				comic.getNumber(),
				comic.getPicture(),
				comic.getPrice(),
				comic.getState(),
				comic.getReaded(),
				comic.getGrade()
		};
		
		setSqlParams(sqlParams);
		
		executaInsert();
	}
	
	public void atualiza(){
		StringBuffer sql = new StringBuffer();
		
		sql.append("update comic ");
		sql.append("   set collection = ?,");
		sql.append("       title = ?,");
		sql.append("       number = ?,");
		sql.append("       picture = ?,");
		sql.append("       price = ?,");
		sql.append("       state = ?,");
		sql.append("       readed = ?,");
		sql.append("       grade = ?");
		sql.append(" where id = ? ");
		
		setSql(sql.toString());
		
		Object[] sqlParams = {
				comic.getCollection(),
				comic.getTitle(),
				comic.getNumber(),
				comic.getPicture(),
				comic.getPrice(),
				comic.getState(),
				comic.getReaded(),
				comic.getGrade(),
				comic.getId()
		};
		
		setSqlParams(sqlParams);
		
		executaUpdate();
	}
	
	public List<Comic> lista(Collection collection){
		List<Comic> list = new ArrayList<Comic>();
		
		String sql = "select * from comic where collection = " + collection.getId();
		setSql(sql);
		ResultSet rs = list();
		
		try{
		
			while(rs.next()){
				list.add(new Comic(rs.getInt("id"),
						rs.getInt("collection"),
						rs.getString("title"),
						rs.getInt("number"),
						rs.getString("picture"),
						rs.getDouble("price"),
						rs.getInt("state"),
						rs.getBoolean("readed"),
						rs.getInt("grade"),
						null));
			}
			
			return list;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

}
