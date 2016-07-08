package br.com.solimar.sidosp.m1.test;

import javax.inject.Inject;

import org.jboss.arquillian.junit.InSequence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.solimar.sidosp.core.domain.Doador;
import br.com.solimar.sidosp.m1.business.DoadorBC;

public class DoadorTest extends AbstractTest {

	private static final long serialVersionUID = 1L;
	@Inject
	DoadorBC doadorBC;

	@Test
	@InSequence(1)
	public void deleteAll() {
		doadorBC.deleteAll();
		assertEquals(doadorBC.findAll().size(), 0);
	}
	
	@Test
	@InSequence(2)
	public void insert() {
		Doador d = new Doador();
		d.setMail("admin");
		d.setName("Solimar Silva e Silva");
		d.setPassword("123");
		doadorBC.insert(d);
		assertEquals(doadorBC.findAll().size(), 1);
	}

}
