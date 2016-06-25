package br.com.solimar.sidosp.m1.view.application;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean
public class MenuControllerMB {
	
	
	public String getItemCssClass(String viewId) {
		FacesContext context = FacesContext.getCurrentInstance();
		String currentViewId = context.getViewRoot().getViewId();
		
		//viewId = "/pages/" + viewId + ".xhtml";
		viewId = "/pages/" + viewId;
		
		//log.info("[getItemCssClass] currentViewId: "+currentViewId);
		
		return currentViewId.contains(viewId) ? "is-selected" : null;
	}

}
