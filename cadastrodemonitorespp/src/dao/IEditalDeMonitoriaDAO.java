package dao;

import java.util.ArrayList;

import dto.EditalDeMonitoriaDTO;

public interface IEditalDeMonitoriaDAO {
		
	public void salvarEdital(EditalDeMonitoriaDTO edital);
	
	public void excluirEdital(EditalDeMonitoriaDTO id) throws Exception;
	
	public void editarEdital(EditalDeMonitoriaDTO id) throws Exception;
	
	public ArrayList<EditalDeMonitoriaDTO> buscarEditais() throws Exception;

}
