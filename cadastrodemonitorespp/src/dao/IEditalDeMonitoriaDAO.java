package dao;

import java.time.LocalDateTime;

import dto.EditalDeMonitoriaDTO;

public interface IEditalDeMonitoriaDAO {
		
	public void salvarEdital(EditalDeMonitoriaDTO edital);
	
	public void excluirEdital(EditalDeMonitoriaDTO id);
	
	public void editarEdital(EditalDeMonitoriaDTO id);
	

}
