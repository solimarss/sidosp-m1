package br.com.solimar.sidosp.m1.test;

import java.io.Serializable;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

import br.com.solimar.sidosp.m1.sis.producer.EntityManagerProducer;

@RunWith(Arquillian.class)
public abstract class AbstractTest implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public final static String PKG_BUSINESS = "br.com.solimar.sidosp.m1.business";
	public final static String PKG_DOMAIN = "br.com.solimar.sidosp.core.domain";
	public final static String PKG_VIEW = "br.com.solimar.sidosp.m1.view";
	public final static String PKG_PERSISTENCE = "br.com.solimar.sidosp.m1.persistence";
	public final static String PKG_PRODUCER = "br.com.solimar.sidosp.m1.sis.producer";
	public final static String PERSISTENCE_XML = "META-INF/persistence.xml";
	public final static String BEANS_XML = "beans.xml";
	

	@Deployment
	public static Archive<?> criarArquivoTeste() {
		Archive<?> arquivoTeste = ShrinkWrap
				.create(WebArchive.class, "aplicacaoTeste.war")
				.addPackage(AbstractTest.PKG_BUSINESS)
				.addPackage(AbstractTest.PKG_PERSISTENCE)
				.addPackage(AbstractTest.PKG_VIEW)
				.addPackage(AbstractTest.PKG_DOMAIN)
				.addPackage(AbstractTest.PKG_PRODUCER)
				.addClass(AbstractTest.class)
				.addAsResource(AbstractTest.PERSISTENCE_XML)
				.addAsWebInfResource(EmptyAsset.INSTANCE,
						AbstractTest.BEANS_XML);
		return arquivoTeste;
	}

}