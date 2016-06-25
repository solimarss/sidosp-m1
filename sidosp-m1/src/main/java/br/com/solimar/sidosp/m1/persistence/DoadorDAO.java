package br.com.solimar.sidosp.m1.persistence;

import javax.ejb.Stateless;

import br.com.solimar.sidosp.core.domain.Doador;

@Stateless
public class DoadorDAO extends AbstractDao<Doador> {

	private static final long serialVersionUID = 1L;

	DoadorDAO() {
		super(Doador.class);
	}

}
