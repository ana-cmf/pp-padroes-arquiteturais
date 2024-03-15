package dao;


import java.util.ArrayList;

import BD.CentralDeInformacoes;
import dto.EditalDeMonitoriaDTO;
import dto.VagaDTO;  
import model.EditalDeMonitoria;


public class EditalDeMonitoriaDAO implements IEditalDeMonitoriaDAO {


	public void salvarEdital(EditalDeMonitoriaDTO edital) throws Exception {
		
		PersistenciaDAO persistencia = new PersistenciaDAO();
		CentralDeInformacoes central = persistencia.recuperarCentral("central.xml");
		central.getTodosOsEditais().add(edital);
		persistencia.salvarCentral(central, "central.xml");
		
	}
	@Override
	public void excluirEdital(EditalDeMonitoriaDTO editaldto) throws Exception {
		PersistenciaDAO persistencia = new PersistenciaDAO();
		CentralDeInformacoes central = persistencia.recuperarCentral("central.xml");
		for (EditalDeMonitoriaDTO edital: central.getTodosOsEditais()) {
			if (edital.getId() == editaldto.getId() ) {
				central.getTodosOsEditais().remove(edital);
		}
		persistencia.salvarCentral(central, "central.xml");
	}
	}

	@Override
	public void editarEdital(EditalDeMonitoriaDTO id) throws Exception {
		PersistenciaDAO persistencia = new PersistenciaDAO();
		CentralDeInformacoes central = persistencia.recuperarCentral("central.xml");
		for (EditalDeMonitoriaDTO edital: central.getTodosOsEditais()) {
			if (edital.getId() == id.getId() ) {
				//edital.editar(id);
				
			}
		persistencia.salvarCentral(central, "central - xml");
		}		
	}
	
	public ArrayList<EditalDeMonitoriaDTO> buscarEditais() throws Exception{
		
		PersistenciaDAO persistencia = new PersistenciaDAO();
		CentralDeInformacoes central = persistencia.recuperarCentral("central.xml");
		return central.getTodosOsEditais();
	}
}  