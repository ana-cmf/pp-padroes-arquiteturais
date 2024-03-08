package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditalDeMonitoria {

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
	
	public LocalDateTime getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public String getStatus() {
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
	
	public ArrayList<Vaga> getVagas() {
		return vagas;
	}
	
	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}
	
	public boolean jaAcabou() {
		return LocalDateTime.now().isAfter(dataFinal);
	}
	
	public boolean jaComecou() {
		return LocalDateTime.now().isAfter(dataInicio);
	}
	
	public boolean inscrever(Aluno aluno, String disciplina) {
		if (!jaAcabou() && jaComecou()) {
			for (Vaga vaga: vagas) {
				if (vaga.getDisciplina().equalsIgnoreCase(disciplina)) {
					vaga.getListaDeAlunosInscritos().add(aluno);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void encerrarEditalAntesDoTempo() {
		dataEmQueEncerrou = LocalDateTime.now();
	}
	
	public void reabrirEdital() {
		if (encerrouAntesDoTempo()) {
			dataEmQueEncerrou = null;
		}
	}
	
	
	public EditalDeMonitoria(String numero, LocalDateTime dataInicio, LocalDateTime dataFinal) {
		this.id = System.currentTimeMillis();
		this.numero = numero;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}
	
	
	public EditalDeMonitoria() {
		this.id = System.currentTimeMillis();
	}
	
	
	public void gerarResultado() {
		for (Vaga vaga: vagas) {
			vaga.gerarRankingDaVaga();
		}
		resultadoCalculado = true;
	}
	
	public String toString() {
		
		String numero = "Número: " + this.numero;
		
		DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("d/M/y");
		
		String dataInicial = "Data de início: " + this.dataInicio.toLocalDate().format(formatoDaData);
		
		String dataFinal = "Data final: ";
		
		if(encerrouAntesDoTempo()) {
			dataFinal = dataFinal + this.dataEmQueEncerrou.toLocalDate().format(formatoDaData);
		} else {
			dataFinal = dataFinal + this.dataFinal.toLocalDate().format(formatoDaData);
		}
		
		String pesoNota = "Peso da nota na disciplina: " + this.pesoNota;
		String pesoCRE = "Peso do CRE: " + this.pesoCRE;
		String maximoDeInscricoesPorAluno = "Máximo de inscrições por aluno: " + this.maximoDeInscricoesPorAluno;

		
		String infoVagas = "";
		for (Vaga vaga: vagas) {
			infoVagas += vaga.getDisciplina()+" - "+vaga.getQuantidadeDeVagas()+" vagas\n";
		}
		
		
		String infoEdital = numero + "\n" +
							dataInicial + "\n" +
							dataFinal + "\n" +
							pesoNota + "\n" +
							pesoCRE + "\n" +
							maximoDeInscricoesPorAluno + "\n" +
							infoVagas;
		return infoEdital;
	}
	
	public EditalDeMonitoria clone() {
		EditalDeMonitoria editalClonado = new EditalDeMonitoria(numero, dataInicio, dataFinal);
		editalClonado.setVagas(vagas);
		editalClonado.setClonado(true);
		editalClonado.setDataEmQueEncerrou(dataEmQueEncerrou);
		
		return editalClonado;
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
		this.pesoNota = pesoNota;
	}
	public float getPesoCRE() {
		return pesoCRE;
	}
	public void setPesoCRE(float pesoCRE) {
		this.pesoCRE = pesoCRE;
	}
	public int getMaximoDeInscricoesPorAluno() {
		return maximoDeInscricoesPorAluno;
	}
	public void setMaximoDeInscricoesPorAluno(int maximoDeInscricoesPorAluno) {
		this.maximoDeInscricoesPorAluno = maximoDeInscricoesPorAluno;
	}
}
