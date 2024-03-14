package dao;

import BD.CentralDeInformacoes;
import dto.EditalDeMonitoriaDTO;
import dto.VagaDTO;
import model.EditalDeMonitoria;


public class EditalDeMonitoriaDAO implements IEditalDeMonitoriaDAO {

	public void salvarEdital(EditalDeMonitoriaDTO edital) {
		EditalDeMonitoria novoEdital = new EditalDeMonitoria();
		novoEdital = novoEdital.fromDTO(edital);
	}
	@Override
	public void excluirEdital(EditalDeMonitoriaDTO id) {
		
		for (EditalDeMonitoria edital: getTodosOsEditais().) {
			
		}
		
	}

	@Override
	public void editarEdital(EditalDeMonitoriaDTO id) {
		// TODO Auto-generated method stub
		
	}

	
}