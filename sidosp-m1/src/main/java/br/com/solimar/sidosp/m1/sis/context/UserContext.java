package br.com.solimar.sidosp.m1.sis.context;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.solimar.sidosp.core.domain.Doador;
import br.com.solimar.sidosp.m1.domain.User;
 
@SuppressWarnings("serial")
@Named
@SessionScoped
public class UserContext implements Serializable{
     
     
    private User user;
    
    private Doador doador;
    
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}
    
    
     
}
