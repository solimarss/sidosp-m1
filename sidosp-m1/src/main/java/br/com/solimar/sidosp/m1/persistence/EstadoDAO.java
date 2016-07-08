package br.com.solimar.sidosp.m1.persistence;

import javax.ejb.Stateless;

import br.com.solimar.sidosp.core.domain.Estado;

@Stateless
public class EstadoDAO extends AbstractDao<Estado> {

	private static final long serialVersionUID = 1L;

	EstadoDAO() {
		super(Estado.class);
	}
	
	

}
