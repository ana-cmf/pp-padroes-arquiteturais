package BD;

import java.util.ArrayList;

import dto.AlunoDTO;
import dto.CoordenadorDTO;
import dto.EditalDeMonitoriaDTO;
import model.Coordenador;
import model.EditalDeMonitoria;
public class CentralDeInformacoes {
	
	private Coordenador coordenador;
	private ArrayList<EditalDeMonitoria> todosOsEditais = new ArrayList<EditalDeMonitoria>();
	
	public Coordenador getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
	public ArrayList <EditalDeMonitoria> getTodosOsEditais() {
		return todosOsEditais;
	}
	public void setTodosOsEditais(ArrayList <EditalDeMonitoria> todosOsEditais) {
		this.todosOsEditais = todosOsEditais;
	}
}
