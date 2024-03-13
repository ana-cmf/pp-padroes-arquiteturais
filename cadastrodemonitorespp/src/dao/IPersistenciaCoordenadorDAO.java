package dao;

import dto.CoordenadorDTO;

public interface IPersistenciaCoordenador {

	public void cadastrarCoordenador(CoordenadorDTO coordenadorDTO) throws Exception;
	
	public CoordenadorDTO buscarCoordenador(CoordenadorDTO coord);
}
