package controller;

import dao.PersistenciaCoordenador;
import dto.CoordenadorDTO;
import view.CoordenadorVerEditais;
import view.ModeloJanelaComTabela;
import view.TelaCadastrarEditalCoordenador;

public class CoordenadorController {
	
	private ModeloJanelaComTabela janelaComTabela;
	private PersistenciaCoordenador coordenadorDAO;
	
	public void salvarCoordenador(CoordenadorDTO coordenadorDTO) {
		
		coordenadorDAO.cadastrarCoordenador(coordenadorDTO);
	}
	
	public CoordenadorDTO procurarCoordenador() {
		
		return coordenadorDAO.buscarCoordenador();
	}
	
	public void abrirTelaDeListarAlunos() {

	}
	
	public void abrirTelaDeListarEditais() {
		
		janelaComTabela.dispose();
		new CoordenadorVerEditais();
	}

	public void abrirTelaDeCadastroDeEdital() {
	
		janelaComTabela.dispose();
		new TelaCadastrarEditalCoordenador();
	}

	public PersistenciaCoordenador getCoordenadorDAO() {
		return coordenadorDAO;
	}
	
	public void setCoordenadorDAO(PersistenciaCoordenador coordenadorDAO) {
		this.coordenadorDAO = coordenadorDAO;
	}

	public ModeloJanelaComTabela getJanelaComTabela() {
		return janelaComTabela;
	}

	public void setJanelaComTabela(ModeloJanelaComTabela janelaComTabela) {
		this.janelaComTabela = janelaComTabela;
	}
}
