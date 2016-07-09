package br.com.solimar.sidosp.m1.test;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;

import br.com.solimar.sidosp.core.domain.Cidade;
import br.com.solimar.sidosp.core.domain.Estado;
import br.com.solimar.sidosp.m1.business.CidadeBC;
import br.com.solimar.sidosp.m1.business.EstadoBC;

public class CidadeTest extends AbstractTest {

	private static final long serialVersionUID = 1L;
	@Inject
	private CidadeBC cidadeBC;
	@Inject
	private EstadoBC estadoBC;

	@Test
	@InSequence(1)
	public void deleteAll() {
		cidadeBC.deleteAll();
		estadoBC.deleteAll();
		assertEquals(cidadeBC.findAll().size(), 0);
		assertEquals(estadoBC.findAll().size(), 0);
		
		
	}
	
	@Test
	@InSequence(2)
	public void insert() {
		
		Estado pa = new Estado("Pará", "PA");
		Estado ma = new Estado("Maranhão", "MA");
		
		estadoBC.insert(pa);
		estadoBC.insert(ma);
		
		Cidade belem = new Cidade("Belém", pa);
		Cidade maraba = new Cidade("Marabá", pa);
		Cidade santarem = new Cidade("Santarém", pa);
		Cidade saoLuiz = new Cidade("São Luíz", ma);
		
		
		cidadeBC.insert(belem);
		cidadeBC.insert(maraba);
		cidadeBC.insert(santarem);
		cidadeBC.insert(saoLuiz);
		
		
		
		assertEquals(cidadeBC.findAll().size(), 4);
		assertEquals(estadoBC.findAll().size(), 2);
	}

}
