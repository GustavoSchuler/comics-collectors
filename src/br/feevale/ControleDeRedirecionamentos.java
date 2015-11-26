package br.feevale;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.util.Util;

public class ControleDeRedirecionamentos 
				implements PhaseListener {

	@Override
	public void afterPhase( PhaseEvent event ) {

		FacesContext facesContext = event.getFacesContext();
		
		if( facesContext != null && 
			facesContext.getViewRoot() != null &&
			facesContext.getViewRoot().getViewId() != null ) {
			
			String currentPage = facesContext.getViewRoot().getViewId();
			boolean necessitaLogin = false;
			
			System.out.println( "CurrentPage: " + currentPage );
			
			if( !currentPage.endsWith( "login.xhtml" ) ) {
				necessitaLogin = true;
			}
			
			if( necessitaLogin ) {
				
				System.out.println( Util.getSession().getAttribute( "user" ) );
				
				if( Util.getSession().getAttribute( "user" ) == null ) {
					NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
					nh.handleNavigation( facesContext, null, "loginPage" );
				}
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}