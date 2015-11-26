package br.componentes.components;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;

@FacesComponent("UserLogado")
public class UserLogado extends UIOutput {
	
//	private enum PropertyKeys { 
//		texto 
//	}
	
//	public void setTexto( String txTexto ) {
//		getStateHelper().put( PropertyKeys.texto, txTexto );
//	}
//	
//	public String getTexto() {
//		return (String) getStateHelper().eval( PropertyKeys.texto, "Eu tenho a Força" );
//	}
	
	@Override
	public String getFamily() {
		return "br.feevale.faces.UserLogado";
	}
}