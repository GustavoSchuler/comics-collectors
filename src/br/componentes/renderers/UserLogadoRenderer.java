package br.componentes.renderers;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

import br.componentes.components.UserLogado;
import br.model.User;
import br.util.Util;

@FacesRenderer(componentFamily="br.feevale.faces.UserLogado",rendererType="UserLogado")
public class UserLogadoRenderer extends Renderer {
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		
		UserLogado alerta = (UserLogado) component;
		ResponseWriter writer = context.getResponseWriter();
				
		writer.write( "<!-- Usuário logado nessa bagaça -->" );
		writer.startElement( "div", component );
		writer.writeAttribute( "class", "userLogado text-right", null );

		writer.write( "<h2>" );
		writer.write( "Bem-vindo " + ((User) Util.getSession().getAttribute( "user" )).getName() );
		writer.write( "</h2>");
		writer.endElement( "div" );	
	}	
}











