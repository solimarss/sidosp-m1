package br.com.solimar.sidosp.m1.view.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.solimar.sidosp.core.domain.Doador;
import br.com.solimar.sidosp.m1.business.DoadorBC;
import br.com.solimar.sidosp.m1.domain.Role;
import br.com.solimar.sidosp.m1.domain.User;
import br.com.solimar.sidosp.m1.sis.context.UserContext;
import br.com.solimar.sidosp.m1.sis.producer.Log;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class AuthenticatorMB implements Serializable {

	private String password;
	private String username;
	@Inject
	private UserContext userContext;
	@Inject
	private DoadorBC doadorBC;
	@Inject
	@Log
	private Logger log;

	public String logar() {
				
		log.debug("logger debug: " + username);
		log.info("logger info: " + username);
		log.warn("logger warn: " + username);

		try {

			Doador doador = doadorBC.findByMailAndPassword(username, password);

			if (doador != null) {
				User user = new User();
				Role role = new Role();
				role.setName("ROLE_DOADOR");
				role.setId(1L);
				List<Role> roles = new ArrayList<Role>();
				roles.add(role);
				user.setRoles(roles);
				loginSpringSecurity(user);
				log.info("Login realizado com sucesso");
				return "/pages/inicio/inicio.jsf?faces-redirect=true";
				
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"E-mail ou senha errados", null));
				
				return null;
			}
			
			
		} catch (IllegalArgumentException ex) {
			message(ex.getMessage());
		}
		return null;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private void loginSpringSecurity(User user) {
		userContext.setUser(user);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user.getUsername(), null, user.getRoles());
		token.setDetails(user);

		SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.getContext().setAuthentication(token);
	}

	public String logout() {
		userContext.setUser(null);
		SecurityContextHolder.clearContext();
		return "/security/login.jsf?faces-redirect=true";
	}

	private void message(String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(message));
	}

}