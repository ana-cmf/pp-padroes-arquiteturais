package dao;

import dto.CoordenadorDTO;

public interface PersistenciaCoordenador {

	public void cadastrarCoordenador(CoordenadorDTO coordenadorDTO);
	
	public CoordenadorDTO buscarCoordenador();
}
