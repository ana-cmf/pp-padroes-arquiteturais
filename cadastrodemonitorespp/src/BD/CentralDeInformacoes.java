package BD;

import java.util.ArrayList;

import dto.EditalDeMonitoriaDTO;

public class CentralDeInformacoes {
	
	private ArrayList<EditalDeMonitoriaDTO> todosOsEditais = new ArrayList<EditalDeMonitoriaDTO>();
	
	public ArrayList <EditalDeMonitoriaDTO> getTodosOsEditais() {
		return todosOsEditais;
	}
	public void setTodosOsEditais(ArrayList <EditalDeMonitoriaDTO> todosOsEditais) {
		this.todosOsEditais = todosOsEditais;
	}
}
