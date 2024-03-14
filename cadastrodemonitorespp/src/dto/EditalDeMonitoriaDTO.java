package dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Vaga;

public class EditalDeMonitoriaDTO {
	
	private long id;
	private String numero;
	private LocalDateTime dataInicio;
	private LocalDateTime dataEmQueEncerrou;
	private LocalDateTime dataFinal;
	private String status; 
	private boolean clonado;
	private boolean resultadoCalculado;
	private float pesoNota;
	private float pesoCRE;
	private ArrayList<Vaga> vagas = new ArrayList<Vaga>();
	private int maximoDeInscricoesPorAluno;
	
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
		this.dataInicio = dataInicio;
	}
	public LocalDateTime getDataEmQueEncerrou() {
		return dataEmQueEncerrou;
	}
	public void setDataEmQueEncerrou(LocalDateTime dataEmQueEncerrou) {
		this.dataEmQueEncerrou = dataEmQueEncerrou;
	}
	public LocalDateTime getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
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
	public float getPesoNota() {
		return pesoNota;
	}
	public void setPesoNota(float pesoNota) {
		this.pesoNota = pesoNota;
	}
	public float getPesoCRE() {
		return pesoCRE;
	}
	public void setPesoCRE(float pesoCRE) {
		this.pesoCRE = pesoCRE;
	}
	public ArrayList<Vaga> getVagas() {
		return vagas;
	}
	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}
	public int getMaximoDeInscricoesPorAluno() {
		return maximoDeInscricoesPorAluno;
	}
	public void setMaximoDeInscricoesPorAluno(int maximoDeInscricoesPorAluno) {
		this.maximoDeInscricoesPorAluno = maximoDeInscricoesPorAluno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
