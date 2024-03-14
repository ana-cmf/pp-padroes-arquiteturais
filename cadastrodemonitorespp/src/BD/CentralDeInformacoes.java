package BD;

import java.util.ArrayList;

<<<<<<< HEAD
=======
import dto.AlunoDTO;
import dto.EditalDeMonitoriaDTO;
import model.Coordenador;
>>>>>>> 16580ddc2ee320607a5a0b0e87bdba7e3dfaa808
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
