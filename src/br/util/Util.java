package br.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.model.UploadedFile;

public class Util {
	
	public static HttpSession getSession() {
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		HttpSession session = request.getSession();
		
		return session;
	}
	
	public static void sendRedirect( String praOnde ) throws IOException {
		
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		
		HttpServletResponse response = (HttpServletResponse) context.getResponse();
		response.sendRedirect( praOnde );
	}
	
	public static void salvaImagem(UploadedFile file, String newFilePath){
		byte[] img = file.getContents();
//		String newFilePath = getClass().getClassLoader().getResource("collection/resources/images/collection") + nome + uploadedFileName.substring( uploadedFileName.indexOf(".") , uploadedFileName.length());
		
		try{
			String nome = newFilePath + "/" + file.getFileName();
			File newfile = new File(nome);
			newfile.createNewFile();
			FileOutputStream fos = new FileOutputStream(newFilePath);
			try {
			    fos.write(img);
			}finally {
			    fos.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}