package br.com.academia.controller;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Classes com métodos comuns a todos os controllers.
 * @author MARCOS
 *
 */
public class AbstractController {
	
	public void getConfigSpring(){
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getAutowireCapableBeanFactory()
				.autowireBean(this);
	}

}
