package br.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.util.Conexao;

public class BaseController {
	
	private Connection conexao;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private String sql;
	private Object[] sqlParams;
	
	protected BaseController(){
		conexao = Conexao.getConnection();
	}
	
	protected boolean executaInsert(){
		try {
			preparedStatement = conexao.prepareStatement(sql);
			
			for(int i=0; i<=sqlParams.length-1; i++){
				preparedStatement.setObject(i+1, sqlParams[i]);
			}
			
			return preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected boolean executaUpdate(){
		try {
			preparedStatement = conexao.prepareStatement(sql);
			
			for(int i=0; i<=sqlParams.length-1; i++){
				preparedStatement.setObject(i+1, sqlParams[i]);
			}
			
			return preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected void executaDelete() {
		try {
			preparedStatement = conexao.prepareStatement(sql);
			
			for(int i=0; i<=sqlParams.length-1; i++){
				preparedStatement.setObject(i+1, sqlParams[i]);
			}
			
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet list(){
		
		try {
			preparedStatement = conexao.prepareStatement(sql);
			
			if(sqlParams != null){
				for(int i=0; i<=sqlParams.length-1; i++){
					preparedStatement.setObject(i+1, sqlParams[i]);
				}
			}
			
			resultSet = preparedStatement.executeQuery();
			
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Object[] getSqlParams() {
		return sqlParams;
	}

	public void setSqlParams(Object[] sqlParams) {
		this.sqlParams = sqlParams;
	}

}
