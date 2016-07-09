package br.com.solimar.sidosp.m1.persistence;

import javax.ejb.Stateless;

import br.com.solimar.sidosp.core.domain.Cidade;

@Stateless
public class CidadeDAO extends AbstractDao<Cidade> {

	private static final long serialVersionUID = 1L;

	CidadeDAO() {
		super(Cidade.class);
	}
	
	

}
