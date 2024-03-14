package BD;

import java.util.ArrayList;

import model.EditalDeMonitoria;
public class CentralDeInformacoes {
	
	private ArrayList<EditalDeMonitoria> todosOsEditais = new ArrayList<EditalDeMonitoria>();
	
	public ArrayList <EditalDeMonitoria> getTodosOsEditais() {
		return todosOsEditais;
	}
	public void setTodosOsEditais(ArrayList <EditalDeMonitoria> todosOsEditais) {
		this.todosOsEditais = todosOsEditais;
	}
}
