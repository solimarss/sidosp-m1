package br.com.solimar.sidosp.m1.view.doacao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.solimar.sidosp.m1.business.EstadoBC;

@Named
@javax.faces.view.ViewScoped
public class DoacaoAgendMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private EstadoBC estadoBC;
	
	@PostConstruct
	private void init() {
		
	}

	public void save() {
		System.out.println("save");
	}
	
	
	

	
}
