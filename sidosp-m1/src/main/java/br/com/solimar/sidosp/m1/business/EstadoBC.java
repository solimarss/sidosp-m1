package br.com.solimar.sidosp.m1.business;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.solimar.sidosp.core.domain.Cidade;
import br.com.solimar.sidosp.core.domain.Estado;
import br.com.solimar.sidosp.m1.persistence.CidadeDAO;
import br.com.solimar.sidosp.m1.persistence.EstadoDAO;

@Stateless
public class EstadoBC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoDAO estadoDAO;
	
	@Inject
	private CidadeDAO cidadeDAO;

	public Estado find(Long id) {
		return estadoDAO.find(id);
	}
	
	public List<Estado> findAll() {
		return estadoDAO.findAll();
	}

	public void insert(Estado doador) {
		estadoDAO.insert(doador);
	}
	
	public void testeTransacao() {
		//funcionou a integridade da transação sem o @Transactional
		
		Estado estado2 = new Estado();
		estado2.setNome("TESTE@");
		estado2.setSigla("XX");
		estadoDAO.insert(estado2);
		
		
		Cidade cidade = new Cidade();
		cidade.setNome("CIDADE");
		cidade.setEstado(new Estado(10000L));
		cidadeDAO.insert(cidade);
		
	}

	public void deleteAll() {
		estadoDAO.deleteAll();
	}
}
