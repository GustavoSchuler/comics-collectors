package br.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.model.User;
import br.util.Conexao;
import br.util.Util;

@ManagedBean
@SessionScoped
public class CtrlLogin {
	
	private String nome;
	private String senha;
	private String email;
	
	private String msgEmail = null;
	
	private Integer idTime;
	private Integer idCliente;
	
	public CtrlLogin() {
		
	}
	
	public void executaAcaoBotao() throws IOException {
		System.out.println( "executaAcaoBotao" );
		//Util.sendRedirect( "./index.jsf" );
	}
	
	public String executaAcaoLink1() {
		System.out.println( "executaAcaoLink" );
		return "success";
	}
	
	public String executaAcaoLink2() {
		System.out.println( "executaAcaoLink" );
		return "error";
	}
	
	public void testaEmail() {
		System.out.println( "Vou testar o email: " + email );
		
		msgEmail = null;
		if( email.indexOf( "@" ) < 1 ) {
			System.out.println( "O email é inválido" );
			msgEmail = "Email inválido";
		}
		
	}
	
	public String logout(){
		Util.getSession().removeAttribute( "user" );
		return "logout";
	}
	
	public String testaLogin() {
		
		String sql = "select* from users where name = ? and password = ?";
		
		Util.getSession().removeAttribute( "NomeLogin" );
		System.out.println( "Testando nome: " + nome + " com senha " + senha );
		
		try{
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.setString(1, this.nome);
			ps.setString(2, this.senha);
			
			ResultSet rs = ps.executeQuery();
			
			if( rs != null && rs.next()){
				
				User user = new User();
				
				user.setId( rs.getInt("id") );
				user.setName( rs.getString("name") );
				user.setPassword( rs.getString("password") );
				user.setEmail( rs.getString("email") );
				
				Util.getSession().setAttribute( "user", user );
				
				return "success";
			}else{
				return "error";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Integer getIdTime() {
		return idTime;
	}
	
	public void setIdTime(Integer idTime) {
		this.idTime = idTime;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println( "Vou setar o email para: " + email );
		this.email = email;
	}
	
	public String getMsgEmail() {
		return msgEmail;
	}
	
	public void setMsgEmail(String msgEmail) {
		this.msgEmail = msgEmail;
	}
}
