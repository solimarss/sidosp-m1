package br.com.solimar.sidosp.m1.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.solimar.sidosp.core.domain.Cidade;
import br.com.solimar.sidosp.core.domain.Laboratorio;

@Stateless
public class LaboratorioDAO extends AbstractDao<Laboratorio> {

	private static final long serialVersionUID = 1L;

	LaboratorioDAO() {
		super(Laboratorio.class);
	}

	@SuppressWarnings("unchecked")
	public List<Laboratorio> findByCidade(Cidade cidade) {
		cidade = em.find(Cidade.class, cidade.getId());
		Query query = em
				.createQuery(
						"Select C from Laboratorio C Where C.cidade =:pCidade",
						Laboratorio.class);

		query.setParameter("pCidade", cidade);
		
		return query.getResultList();

	}

}
