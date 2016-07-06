package br.com.solimar.sidosp.m1.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

import br.com.solimar.sidosp.core.domain.Doador;

@Stateless
public class DoadorDAO extends AbstractDao<Doador> {

	private static final long serialVersionUID = 1L;

	DoadorDAO() {
		super(Doador.class);
	}
	
	
	
	public void insert(Doador d1, Doador d2){
		try {
			em.persist(d1);
			em.persist(d2);
			
		} catch (Exception e) {
			context.setRollbackOnly();
		}
	}
	

	@SuppressWarnings("unchecked")
	public Doador findByMailAndPassword(String mail, String password) {
		try {
			Query query = em
					.createQuery("Select D from Doador D Where D.mail =:pMail and D.password =:pPassword", Doador.class);
			
			query.setParameter("pMail", mail);
			query.setParameter("pPassword", password);
			
			Doador doador = null;
			List<Doador> lista = query.getResultList();
			
			if(lista.size() > 0){
				doador = lista.get(0);
			}
			return doador;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

}
