package br.com.solimar.sidosp.m1.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.solimar.sidosp.core.domain.Doador;
import br.com.solimar.sidosp.m1.business.DoadorBC;

@RunWith(WeldJUnit4Runner.class)
public class DoacaoTest {
	
	//@Inject
	//private DoadorBC doadorBC;
	
	
	
	
	@Test
	public void agendar(){
		
		System.out.println(getClass().getResource("META-INF/persistence.xml"));
		
		try {
			//Doador doador = doadorBC.findByMailAndPassword("sol", "123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
