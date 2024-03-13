package dao;

import dto.CoordenadorDTO;

public interface ICoordenadorDAO {

	public void cadastrarCoordenador(CoordenadorDTO coordenadorDTO) throws Exception;
	
	public CoordenadorDTO buscarCoordenador(CoordenadorDTO coord);
}
