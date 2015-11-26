package br.util;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Util {
	
	public static HttpSession getSession() {
		
		ExternalContext context = FacesContext.
				                    getCurrentInstance().
				                    getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		HttpSession session = request.getSession();
		
		return session;
	}
	
	public static void sendRedirect( String praOnde ) throws IOException {
		
		ExternalContext context = FacesContext.
                getCurrentInstance().
                getExternalContext();
		
		HttpServletResponse response = (HttpServletResponse) context.getResponse();
		response.sendRedirect( praOnde );
	}
}