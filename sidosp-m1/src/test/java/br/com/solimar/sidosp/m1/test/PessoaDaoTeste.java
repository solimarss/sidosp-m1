package br.com.solimar.sidosp.m1.test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.solimar.sidosp.core.domain.Doador;
import br.com.solimar.sidosp.m1.business.DoadorBC;
import br.com.solimar.sidosp.m1.persistence.DoadorDAO;
import br.com.solimar.sidosp.m1.sis.producer.EntityManagerProducer;

@RunWith(Arquillian.class)
public class PessoaDaoTeste {
 

	@Deployment
	public static Archive<?> criarArquivoTeste() {
		Archive<?> arquivoTeste = ShrinkWrap.create(WebArchive.class, "aplicacaoTeste.war")
				// Adicionando o pacote inteiro da classe PessoaDao, ou seja incluí todas as outras classes deste pacote
				.addPackage("br.com.solimar.sidosp.m1.business")
				.addPackage(DoadorDAO.class.getPackage())
				.addPackage(Doador.class.getPackage())
				.addPackage(EntityManagerProducer.class.getPackage())
				// Adicionando apenas a classe Pessoa, e não o pacote inteiro como na linha anterior
				.addClass(DoadorBC.class)
				// Adicionando o arquivo persistence.xml para conexão JPA
				.addAsResource("META-INF/persistence.xml")
				// Adicionando o beans.xml para ativação do CDI
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		return arquivoTeste;
	}

	@Inject
	DoadorBC doadorBC;

	@Test
	@InSequence(1)
	public void testeSalvarPessoa() {
		
		
		doadorBC.findByMailAndPassword("sol", "123");
		Doador d = new Doador();
		d.setMail("test1");
		d.setPassword("sasa");
		
		Doador d2 = new Doador();
		d2.setMail("test2");
		d2.setPassword("sasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasa");
		
		doadorBC.insert(d, d2);
		

	}


}
