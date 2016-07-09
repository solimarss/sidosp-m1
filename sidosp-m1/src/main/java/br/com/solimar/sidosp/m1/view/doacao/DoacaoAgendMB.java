package br.com.solimar.sidosp.m1.view.doacao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import br.com.solimar.sidosp.core.domain.Cidade;
import br.com.solimar.sidosp.core.domain.Estado;
import br.com.solimar.sidosp.m1.business.CidadeBC;
import br.com.solimar.sidosp.m1.business.EstadoBC;
import br.com.solimar.sidosp.m1.sis.producer.Log;

@Named
@javax.faces.view.ViewScoped
public class DoacaoAgendMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@Log
	private Logger log;
	
	@Inject
	private EstadoBC estadoBC;
	
	@Inject
	private CidadeBC cidadeBC;
	
	private List<Estado> estadosListBox;
	private List<Cidade> cidadesListBox;
	private Long idEstadoSelected;
	
	@PostConstruct
	private void init() {
		estadosListBox = estadoBC.findAll();
		
	}

	public void save() {
		System.out.println("save");
	}


	
	
	
	public void ajaxComboEstado() {
		log.info("[ajaxComboEstado]");
		cidadesListBox = cidadeBC.findByUf(new Estado(idEstadoSelected));
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

	public Long getIdEstadoSelected() {
		return idEstadoSelected;
	}

	public void setIdEstadoSelected(Long idEstadoSelected) {
		this.idEstadoSelected = idEstadoSelected;
	}
	
	
	
	
	
}
