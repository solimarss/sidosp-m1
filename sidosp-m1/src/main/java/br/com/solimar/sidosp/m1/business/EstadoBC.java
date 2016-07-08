package br.com.solimar.sidosp.m1.business;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.solimar.sidosp.core.domain.Estado;
import br.com.solimar.sidosp.m1.persistence.EstadoDAO;

@Stateless
public class EstadoBC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoDAO estadoDAO;

	public Estado find(Long id) {
		return estadoDAO.find(id);
	}
	
	public List<Estado> findAll() {
		return estadoDAO.findAll();
	}

	public void insert(Estado doador) {
		estadoDAO.insert(doador);
	}

	public void deleteAll() {
		estadoDAO.deleteAll();
	}
}
