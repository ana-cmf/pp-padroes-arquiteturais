package dto;

import java.util.ArrayList;

public class CentralDeInformacoesDTO {
	private CoordenadorDTO coordenador;
	private ArrayList <AlunoDTO>todosOsAlunos = new ArrayList<AlunoDTO>();
	private ArrayList <EditalDeMonitoriaDTO>todosOsEditais = new ArrayList<EditalDeMonitoriaDTO>();
	
	public CoordenadorDTO getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(CoordenadorDTO coordenador) {
		this.coordenador = coordenador;
	}
	public ArrayList <EditalDeMonitoriaDTO> getTodosOsEditais() {
		return todosOsEditais;
	}
	public void setTodosOsEditais(ArrayList <EditalDeMonitoriaDTO> todosOsEditais) {
		this.todosOsEditais = todosOsEditais;
	}
	public ArrayList <AlunoDTO> getTodosOsAlunos() {
		return todosOsAlunos;
	}
	public void setTodosOsAlunos(ArrayList <AlunoDTO> todosOsAlunos) {
		this.todosOsAlunos = todosOsAlunos;
	}
 
}
