package br.com.solimar.sidosp.m1.business;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.solimar.sidosp.core.domain.Agendamento;
import br.com.solimar.sidosp.m1.persistence.AgendamentoDAO;

@Stateless
public class AgendamentoBC implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgendamentoDAO DoacaoDAO;

	public Agendamento find(Long id) {
		return DoacaoDAO.find(id);
	}
	
	public List<Agendamento> findAll() {
		return DoacaoDAO.findAll();
	}

	public void insert(Agendamento doador) {
		DoacaoDAO.insert(doador);
	}

	public void deleteAll() {
		DoacaoDAO.deleteAll();
	}
}
