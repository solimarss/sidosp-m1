package br.com.solimar.sidosp.m1.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.solimar.sidosp.core.domain.Doador;

@Stateless
public class DoadorDAO extends AbstractDao<Doador> {

	private static final long serialVersionUID = 1L;

	DoadorDAO() {
		super(Doador.class);
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
