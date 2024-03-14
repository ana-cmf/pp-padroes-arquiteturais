package dao;

import java.time.LocalDateTime;

import dto.EditalDeMonitoriaDTO;

public interface IEditalDeMonitoriaDAO {
		
	public void salvarEdital(EditalDeMonitoriaDTO edital);
	
	public void excluirEdital(EditalDeMonitoriaDTO id) throws Exception;
	
	public void editarEdital(EditalDeMonitoriaDTO id) throws Exception;
	

}
