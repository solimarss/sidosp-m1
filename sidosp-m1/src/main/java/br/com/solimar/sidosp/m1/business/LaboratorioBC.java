package br.com.solimar.sidosp.m1.business;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.solimar.sidosp.core.domain.Cidade;
import br.com.solimar.sidosp.core.domain.Laboratorio;
import br.com.solimar.sidosp.m1.persistence.LaboratorioDAO;

@Stateless
public class LaboratorioBC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private LaboratorioDAO LaboratorioDAO;

	public Laboratorio find(Long id) {
		return LaboratorioDAO.find(id);
	}
	
	public List<Laboratorio> findAll() {
		return LaboratorioDAO.findAll();
	}

	public void insert(Laboratorio doador) {
		LaboratorioDAO.insert(doador);
	}

	public List<Laboratorio> findByCidade(Cidade cidade) {
		return LaboratorioDAO.findByCidade(cidade);
	}
	public void deleteAll() {
		LaboratorioDAO.deleteAll();
	}
}
