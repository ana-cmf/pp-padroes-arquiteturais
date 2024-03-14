package dao;


import java.util.ArrayList;

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
	public void excluirEdital(EditalDeMonitoriaDTO editaldto) throws Exception {
		PersistenciaDAO persistencia = new PersistenciaDAO();
		CentralDeInformacoes central = persistencia.recuperarCentral("central.xml");
		for (EditalDeMonitoriaDTO edital: central.getTodosOsEditais()) {
			if (edital.getId() == editaldto.getId() ) {
				central.getTodosOsEditais().remove(edital);
		}
	}
	}

	@Override
	public void editarEdital(EditalDeMonitoriaDTO id) throws Exception {
		PersistenciaDAO persistencia = new PersistenciaDAO();
		CentralDeInformacoes central = persistencia.recuperarCentral("central.xml");
		for (EditalDeMonitoriaDTO edital: central.getTodosOsEditais()) {
			if (edital.getId() == id.getId() ) {
<<<<<<< HEAD
				//edital.editar(id);
				
			}
		persistencia.salvarCentral(central, "central - xml");
		}		
	}
	
	public ArrayList<EditalDeMonitoriaDTO> buscarEditais() throws Exception{
		
		PersistenciaDAO persistencia = new PersistenciaDAO();
		CentralDeInformacoes central = persistencia.recuperarCentral("central.xml");
		return central.getTodosOsEditais();
=======
				edital = id;
				
			}
		persistencia.salvarCentral(central, "central. xml");
			}		
>>>>>>> 6be7e16abdffe353b1ad8787b1d66ce6101f5484
	}
}  