package dao;

import dto.CentralDeInformacoesDTO;
import dto.CoordenadorDTO;

public class CoordenadorDAO implements IPersistenciaCoordenador{
	
	@Override
	public void cadastrarCoordenador(CoordenadorDTO coordenadorDTO)  throws Exception {
		
		CoordenadorDTO coord = new CoordenadorDTO();
		coord.setNome(getNome().getText());
		coord.setSobrenome(getSobrenome().getText());
		coord.setEmail(getEmail().getText());
		coord.setSenha(getSennha().getText());
		
		PersistenciaDAO persistencia = new PersistenciaDAO();
		CentralDeInformacoes central = null;
		
	}

	@Override
	public CoordenadorDTO buscarCoordenador(CoordenadorDTO coord) {
		if( coord != null) {
			return coord;
	}
		return null;
	}
	
} 