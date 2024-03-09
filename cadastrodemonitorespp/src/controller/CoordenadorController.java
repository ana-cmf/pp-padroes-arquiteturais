package controller;

import dao.PersistenciaCoordenador;
import dto.CoordenadorDTO;

public class CoordenadorController {
	
	private PersistenciaCoordenador coordenadorDAO;
	
	public void salvarCoordenador(CoordenadorDTO coordenadorDTO) {
		
		coordenadorDAO.cadastrarCoordenador(coordenadorDTO);
	}
	
	public CoordenadorDTO procurarCoordenador() {
		
		return coordenadorDAO.buscarCoordenador();
	}

	public PersistenciaCoordenador getCoordenadorDAO() {
		return coordenadorDAO;
	}
	
	public void setCoordenadorDAO(PersistenciaCoordenador coordenadorDAO) {
		this.coordenadorDAO = coordenadorDAO;
	}
}
