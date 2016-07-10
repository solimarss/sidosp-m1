package br.com.solimar.sidosp.m1.persistence;

import javax.ejb.Stateless;

import br.com.solimar.sidosp.core.domain.Agendamento;

@Stateless
public class AgendamentoDAO extends AbstractDao<Agendamento> {

	private static final long serialVersionUID = 1L;

	AgendamentoDAO() {
		super(Agendamento.class);
	}
}
