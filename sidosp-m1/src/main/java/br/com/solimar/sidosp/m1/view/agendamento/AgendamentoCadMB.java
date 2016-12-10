package br.com.solimar.sidosp.m1.view.agendamento;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;

import br.com.solimar.sidosp.core.domain.Cidade;
import br.com.solimar.sidosp.core.domain.Agendamento;
import br.com.solimar.sidosp.core.domain.Estado;
import br.com.solimar.sidosp.core.domain.Laboratorio;
import br.com.solimar.sidosp.m1.business.CidadeBC;
import br.com.solimar.sidosp.m1.business.AgendamentoBC;
import br.com.solimar.sidosp.m1.business.EstadoBC;
import br.com.solimar.sidosp.m1.business.LaboratorioBC;
import br.com.solimar.sidosp.m1.sis.context.UserContext;
import br.com.solimar.sidosp.m1.sis.producer.Log;

@Named
@javax.faces.view.ViewScoped
public class AgendamentoCadMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@Log
	private Logger log;
	
	@Inject
	private AgendamentoBC agendamentoBC;
	
	@Inject
	private EstadoBC estadoBC;
	
	@Inject
	private CidadeBC cidadeBC;
	
	@Inject
	private LaboratorioBC laboratorioBC;
	
	@Inject
	private UserContext userContext;
	
	private List<Estado> estadosListBox;
	private List<Cidade> cidadesListBox;
	private List<Laboratorio> laboratoriosListBox;
	private Agendamento agendamento;
	
	@PostConstruct
	private void init() {
		log.info("[int]");
		estadosListBox = estadoBC.findAll();
		agendamento = new Agendamento();
	}

	public void save() {
		log.info("[save]");
		agendamento.setDoador(userContext.getDoador());
		agendamentoBC.insert(agendamento);
		agendamento = new Agendamento();
		FacesContext.getCurrentInstance().addMessage(
				"Sucesso",
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Agendamento realizado com sucesso", "Sucesso"));
	}

	//@Transactional
	public void testeTransacao() {
		
		//aqui no managedBean funcionou a integridade com o @Transactional
		
		/*Estado estado = new Estado();
		estado.setNome("Amazonas");
		estado.setSigla("AM");
		
		estadoBC.insert(estado);*/
		
	/*	Cidade cidade = new Cidade();
		cidade.setNome("Altamira");
		cidade.setEstado(new Estado(10000L));
		
		cidadeBC.insert(cidade);*/
		estadoBC.testeTransacao();
		
	}

	
	
	
	public void ajaxComboEstado() {
		log.info("[ajaxComboEstado]");
		cidadesListBox = cidadeBC.findByUf(agendamento.getEstado());
	}
	
	public void ajaxComboCidade() {
		log.info("[ajaxComboCidade]");
		laboratoriosListBox = laboratorioBC.findByCidade(agendamento.getCidade());
	}
	
	public void ajaxComboLaboratorio() {
		log.info("[ajaxComboLaboratorio]");
		agendamento.setLaboratorio(laboratorioBC.find(agendamento.getLaboratorio().getId()));
	}
	
	
	/* Getters And Setters */
	public List<Estado> getEstadosListBox() {
		return estadosListBox;
	}

	public void setEstadosListBox(List<Estado> estadosListBox) {
		this.estadosListBox = estadosListBox;
	}

	public List<Cidade> getCidadesListBox() {
		return cidadesListBox;
	}

	public void setCidadesListBox(List<Cidade> cidadesListBox) {
		this.cidadesListBox = cidadesListBox;
	}

	

	public List<Laboratorio> getLaboratoriosListBox() {
		return laboratoriosListBox;
	}

	public void setLaboratoriosListBox(List<Laboratorio> laboratoriosListBox) {
		this.laboratoriosListBox = laboratoriosListBox;
	}


	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	
	
	
	
	
}
