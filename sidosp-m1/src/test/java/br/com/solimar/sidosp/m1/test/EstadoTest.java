package br.com.solimar.sidosp.m1.test;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;

import br.com.solimar.sidosp.core.domain.Estado;
import br.com.solimar.sidosp.m1.business.EstadoBC;

public class EstadoTest extends AbstractTest {

	private static final long serialVersionUID = 1L;
	@Inject
	private EstadoBC estadoBC;

	@Test
	@InSequence(1)
	public void deleteAll() {
		estadoBC.deleteAll();
		assertEquals(estadoBC.findAll().size(), 0);
	}
	
	@Test
	@InSequence(2)
	public void insert() {
		
		Estado pa = new Estado("Pará", "PA");
		Estado ma = new Estado("Maranhão", "MA");
		
		estadoBC.insert(pa);
		estadoBC.insert(ma);
		
		
		assertEquals(estadoBC.findAll().size(), 2);
	}

}
