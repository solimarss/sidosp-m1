package br.com.solimar.sidosp.m1.sis.startup;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.solimar.sidosp.core.domain.Cidade;
import br.com.solimar.sidosp.core.domain.Estado;
import br.com.solimar.sidosp.core.domain.Laboratorio;
import br.com.solimar.sidosp.m1.business.CidadeBC;
import br.com.solimar.sidosp.m1.business.EstadoBC;
import br.com.solimar.sidosp.m1.business.LaboratorioBC;

/*
 Classe usada para popular o banco de dados
 */
@Singleton
@Startup
public class StartUp {

	@Inject
	private LaboratorioBC laboratorioBC;
	@Inject
	private CidadeBC cidadeBC;
	@Inject
	private EstadoBC estadoBC;

	@PostConstruct
	public void init() {
		System.out.println("[init] **************************");

		List<Laboratorio> labs = laboratorioBC.findAll();

		if (labs.size() == 0) {
			System.out.println("[init] banco populado");
			
			laboratorioBC.deleteAll();
			cidadeBC.deleteAll();
			estadoBC.deleteAll();

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

			Laboratorio lab1 = new Laboratorio();
			lab1.setNome("Laboratório Amaral Costa");
			lab1.setLogradouro("Av. Alcindo Cacela");
			lab1.setBairro("Cremação");
			lab1.setCidade(belem);

			Laboratorio lab2 = new Laboratorio();
			lab2.setNome("Laboratório Sabin");
			lab2.setLogradouro("Av. Almirante Barroso 4457");
			lab2.setBairro("Souza");
			lab2.setCidade(belem);

			Laboratorio lab3 = new Laboratorio();
			lab3.setNome("Laboratório Ruth Brazão");
			lab3.setLogradouro("Rua Pedro I 234");
			lab3.setBairro("Centro");
			lab3.setCidade(maraba);

			Laboratorio lab4 = new Laboratorio();
			lab4.setNome("Laboratório Alvaro");
			lab4.setLogradouro("Av. João Barroso 31");
			lab4.setBairro("Comercio");
			lab4.setCidade(maraba);

			laboratorioBC.insert(lab1);
			laboratorioBC.insert(lab2);
			laboratorioBC.insert(lab3);
			laboratorioBC.insert(lab4);
		}

	}
}
