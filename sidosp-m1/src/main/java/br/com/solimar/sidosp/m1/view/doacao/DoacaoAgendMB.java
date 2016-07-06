package br.com.solimar.sidosp.m1.view.doacao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named
@javax.faces.view.ViewScoped
public class DoacaoAgendMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	@PostConstruct
	private void init() {
	}

	public void save() {
		System.out.println("save");
	}
	
	
	

	
}
