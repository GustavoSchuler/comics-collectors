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
	
	public static String salvaImagem(UploadedFile file, String newFilePath){
		
		byte[] img = file.getContents();
		
		try{
			
			File newFile = File.createTempFile("img", file.getFileName().substring( file.getFileName().indexOf("."), file.getFileName().length()), new File(newFilePath));
			String nome = newFilePath + "/" + file.getFileName();
			 
			FileOutputStream fos = new FileOutputStream(newFile);			
			
			try {
				System.out.println( "Salvando:  " + img.length + " bytes");
			    fos.write(img);
			    return newFile.getName();
			}finally {
			    fos.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}