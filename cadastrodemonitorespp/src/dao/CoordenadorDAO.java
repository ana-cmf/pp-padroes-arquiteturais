package dao;

import dto.CentralDeInformacoesDTO;

import dto.CoordenadorDTO;

import model.Coordenador;

public class CoordenadorDAO implements IPersistenciaCoordenador{
	
	@Override
	public void cadastrarCoordenador(CoordenadorDTO coordenadorDTO)  throws Exception {
		
		Coordenador coord = Coordenador.getInstancia();
		coord.setNome(coordenadorDTO.getNome());
		coord.setSobrenome(coordenadorDTO.getSobrenome());
		coord.setEmail(coordenadorDTO.getEmail());
		coord.setSenha(coordenadorDTO.getSenha());
		
		PersistenciaDAO persistencia = new PersistenciaDAO();
		CentralDeInformacoesDTO central = null;
		
	}

	@Override
	public CoordenadorDTO buscarCoordenador(CoordenadorDTO coord) {
		if( coord != null) {
			return coord;
	}
		return null;
	}
	
} 