package br.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MeuListener implements ServletContextListener {
	
	private static String caminhoImagens;

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		caminhoImagens = arg0.getServletContext().getRealPath( "/resources/images/collection" );
		System.out.println( ":--> " + caminhoImagens );
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static String getCaminhoImagens() {
		return caminhoImagens;
	}


}
