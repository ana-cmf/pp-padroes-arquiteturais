package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dto.EditalDeMonitoriaDTO;
import dto.VagaDTO;

public class EditalDeMonitoria {

	private long id;
	private String numero;
	private LocalDateTime dataInicio;
	private LocalDateTime dataEmQueEncerrou;
	private LocalDateTime dataFinal;
	private boolean clonado;
	private boolean resultadoCalculado;
	private float pesoNota;
	private float pesoCRE;
	private ArrayList<VagaDTO> vagas = new ArrayList<VagaDTO>();
	private int maximoDeInscricoesPorAluno;
	
	public EditalDeMonitoria(String numero, LocalDateTime dataInicio, LocalDateTime dataFinal) {
		this.id = System.currentTimeMillis();
		this.numero = numero;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}
	
	
	public EditalDeMonitoria() {
		this.id = System.currentTimeMillis();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDateTime dataInicio) {
		if (LocalDateTime.now().isAfter(dataInicio)) {
			System.out.println("Data Inválida");
		}
		this.dataInicio = dataInicio;

	}
	
	public LocalDateTime getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDateTime dataFinal) {
		if (LocalDateTime.now().isAfter(dataFinal)) {
			System.out.println("Data Inválida");
		}
		this.dataFinal = dataFinal;
	}
	public ArrayList<VagaDTO> getVagas() {
		return vagas;
	}
	
	public void setVagas(ArrayList<VagaDTO> arrayList) {
		this.vagas = arrayList;
	}
	public String status() {
		if(estaComInscricoesAbertas()) {
			return "Inscrições abertas";
		}else if (!jaComecou()){
			return "Inscrições não iniciadas";
		}
		return "Inscrições encerradas";
	}
	
	public boolean estaComInscricoesAbertas() {
		return (!jaAcabou() && !encerrouAntesDoTempo() && jaComecou()); 
	}
	public boolean jaAcabou() {
		return LocalDateTime.now().isAfter(dataFinal);
	}
	
	public boolean jaComecou() {
		return LocalDateTime.now().isAfter(dataInicio);
	}
	
	public void encerrarEditalAntesDoTempo() {
		dataEmQueEncerrou = LocalDateTime.now();
	}
	
	public void reabrirEdital() {
		if (encerrouAntesDoTempo()) {
			dataEmQueEncerrou = null;
		}
	}
	
	public EditalDeMonitoria clone() {
		EditalDeMonitoria editalClonado = new EditalDeMonitoria(numero, dataInicio, dataFinal);
		editalClonado.setVagas(vagas);
		editalClonado.setClonado(true);
		editalClonado.setDataEmQueEncerrou(dataEmQueEncerrou);
		
		return editalClonado;
	}
	
	public void editar(EditalDeMonitoriaDTO editalDTO) {
		
		if(!jaComecou()) {
			dataInicio = editalDTO.getDataInicio();
		}
		
		if(editalDTO.getDataFinal().isBefore(dataFinal)) {
			dataFinal = editalDTO.getDataFinal();
		}
		
		if(editalDTO.getMaximoDeInscricoesPorAluno() > maximoDeInscricoesPorAluno) {
			maximoDeInscricoesPorAluno = editalDTO.getMaximoDeInscricoesPorAluno();
		}
		
		// editar pesos
		
	}
	
	public boolean encerrouAntesDoTempo() {
		if (dataEmQueEncerrou == null) {
			return false;
		}
		return dataEmQueEncerrou.isBefore(dataFinal);
	}
	
	public boolean isClonado() {
		return clonado;
	}
	public void setClonado(boolean clonado) {
		this.clonado = clonado;
	}
	public boolean isResultadoCalculado() { 
		return resultadoCalculado;
	}
	public void setResultadoCalculado(boolean resultadoCalculado) {
		this.resultadoCalculado = resultadoCalculado;
	}
	public LocalDateTime getDataEmQueEncerrou() {
		return dataEmQueEncerrou;
	}
	
	public void setDataEmQueEncerrou(LocalDateTime dataEmQueEncerrou) {
		this.dataEmQueEncerrou = dataEmQueEncerrou;
	}
	public float getPesoNota() {
		return pesoNota;
	}
	public void setPesoNota(float pesoNota) {
		System.out.println("A soma do peso do CRE tem que ser igual a 1");
		this.pesoNota = pesoNota;
	}
	public float getPesoCRE() { 
		return pesoCRE;
	}
	public void setPesoCRE(float pesoCRE) {
		if (pesoCRE != 1) {
			System.out.println("A soma do peso do CRE tem que ser igual a 1");
		}
		this.pesoCRE = pesoCRE;
	}
	public int getMaximoDeInscricoesPorAluno() {
		return maximoDeInscricoesPorAluno;
	}
	public void setMaximoDeInscricoesPorAluno(int maximoDeInscricoesPorAluno) {
		this.maximoDeInscricoesPorAluno = maximoDeInscricoesPorAluno;
	}
	
	public static EditalDeMonitoria fromDTO(EditalDeMonitoriaDTO dto) {
		EditalDeMonitoria edital = new EditalDeMonitoria();
		edital.setId(dto.getId());
		edital.setNumero(dto.getNumero());
		edital.setDataInicio(dto.getDataInicio());
		edital.setDataEmQueEncerrou(dto.getDataEmQueEncerrou());
		edital.setDataFinal(dto.getDataFinal());
		edital.setClonado(dto.isClonado());
		edital.setResultadoCalculado(dto.isResultadoCalculado());
		edital.setPesoNota(dto.getPesoNota());
		edital.setPesoCRE(dto.getPesoCRE());
		edital.setVagas(dto.getVagas());
		edital.setMaximoDeInscricoesPorAluno(dto.getMaximoDeInscricoesPorAluno());
		
		return edital;
	}
	
	public EditalDeMonitoriaDTO toDTO() {
        EditalDeMonitoriaDTO dto = new EditalDeMonitoriaDTO();
        dto.setId(this.id);
		dto.setNumero(this.numero);
		dto.setDataInicio(this.dataInicio);
		dto.setDataEmQueEncerrou(this.dataEmQueEncerrou);
		dto.setDataFinal(this.dataFinal);
		dto.setClonado(this.clonado);
		dto.setResultadoCalculado(this.resultadoCalculado);
		dto.setPesoNota(this.pesoNota);
		dto.setPesoCRE(this.pesoCRE);
		dto.setVagas(this.vagas);
		dto.setMaximoDeInscricoesPorAluno(this.maximoDeInscricoesPorAluno);
        
        return dto;
    }	

}