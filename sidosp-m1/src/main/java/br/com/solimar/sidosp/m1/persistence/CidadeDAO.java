package br.com.solimar.sidosp.m1.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.solimar.sidosp.core.domain.Cidade;
import br.com.solimar.sidosp.core.domain.Doador;
import br.com.solimar.sidosp.core.domain.Estado;

@Stateless
public class CidadeDAO extends AbstractDao<Cidade> {

	private static final long serialVersionUID = 1L;

	CidadeDAO() {
		super(Cidade.class);
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> findByUf(Estado estado) {
		estado = em.find(Estado.class, estado.getId());
		Query query = em
				.createQuery(
						"Select C from Cidade C Where C.estado =:pEstado",
						Cidade.class);

		query.setParameter("pEstado", estado);
		
		return query.getResultList();

	}

}
