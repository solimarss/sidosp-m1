package br.com.solimar.sidosp.m1.test;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import br.com.solimar.sidosp.core.domain.Doador;
import br.com.solimar.sidosp.m1.business.DoadorBC;

public class DoacaoTest {
	
	@Inject
	private Doador doador;
	
	
	
	
	@Test
	public void agendar(){
		
		doador.getName();
		//Doador doador = doadorBC.findByMailAndPassword("sol", "123");
		/*try {
			Query query = em
					.createQuery("Select D from Doador D Where D.mail =:pMail and D.password =:pPassword", Doador.class);
			
			query.setParameter("pMail", "sol");
			query.setParameter("pPassword", "123");
			
			Doador doador = null;
			List<Doador> lista = query.getResultList();
			
			if(lista.size() > 0){
				doador = lista.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}*/
		
	}

}
