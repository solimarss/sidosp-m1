package br.com.solimar.sidosp.m1.business;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.solimar.sidosp.core.domain.Doador;
import br.com.solimar.sidosp.m1.persistence.DoadorDAO;

@Stateless
public class DoadorBC implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DoadorDAO doadorDAO;
	
	public Doador find(Long id){
		return doadorDAO.find(id);
	}
	
	public void insert(Doador doador){
		doadorDAO.insert(doador);
	}
	
	public Doador findByMailAndPassword(String mail, String password){
		return doadorDAO.findByMailAndPassword(mail, password);
	}
	

}
