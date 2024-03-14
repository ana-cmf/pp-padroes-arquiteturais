package controller;

import dao.EditalDeMonitoriaDAO;
import dao.IEditalDeMonitoriaDAO;
import dto.EditalDeMonitoriaDTO;
import model.EditalDeMonitoria;
import view.JanelaVerEditais;

public class EditalDeMonitoriaController {

	private EditalDeMonitoria edital;
	private IEditalDeMonitoriaDAO editalDAO; 
	private JanelaVerEditais janelaVerEditais;
	
	public void encerrarEditalAntesDoTempo(EditalDeMonitoriaDTO editalDTO) throws Exception {
		edital = EditalDeMonitoria.fromDTO(editalDTO);
		edital.encerrarEditalAntesDoTempo();
		editalDTO.setDataEmQueEncerrou(edital.getDataEmQueEncerrou());
		
		editalDAO = new EditalDeMonitoriaDAO();
		editalDAO.editarEdital(editalDTO);
		
		
	}
	
	public void clonarEdital(EditalDeMonitoriaDTO editalDTO) {
		edital = EditalDeMonitoria.fromDTO(editalDTO);
		edital = edital.clone();
		//converter para dto
		editalDAO = new EditalDeMonitoriaDAO();
		editalDAO.salvarEdital(editalDTO);
		janelaVerEditais.getListaDeEditais().add(editalDTO);
	}
	
	public void excluirEdital(EditalDeMonitoriaDTO editalDTO) throws Exception {
		editalDAO = new EditalDeMonitoriaDAO();
		editalDAO.excluirEdital(editalDTO);
		janelaVerEditais.getListaDeEditais().remove(editalDTO);
	}

	public IEditalDeMonitoriaDAO getEditalDAO() {
		return editalDAO;
	}

	public void setEditalDAO(IEditalDeMonitoriaDAO editalDAO) {
		this.editalDAO = editalDAO;
	}

	public JanelaVerEditais getJanelaVerEditais() {
		return janelaVerEditais;
	}

	public void setJanelaVerEditais(JanelaVerEditais janelaVerEditais) {
		this.janelaVerEditais = janelaVerEditais;
	}
	
	
}
