package br.com.solimar.sidosp.m1.business;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.solimar.sidosp.core.domain.Cidade;
import br.com.solimar.sidosp.core.domain.Estado;
import br.com.solimar.sidosp.m1.persistence.CidadeDAO;

@Stateless
public class CidadeBC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CidadeDAO CidadeDAO;

	public Cidade find(Long id) {
		return CidadeDAO.find(id);
	}
	
	public List<Cidade> findAll() {
		return CidadeDAO.findAll();
	}
	
	public List<Cidade> findByUf(Estado estado) {
		return CidadeDAO.findByUf(estado);
	}

	public void insert(Cidade doador) {
		CidadeDAO.insert(doador);
	}

	public void deleteAll() {
		CidadeDAO.deleteAll();
	}
}
