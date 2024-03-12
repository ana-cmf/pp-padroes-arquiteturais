package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.PersistenciaCoordenador;
import dto.CoordenadorDTO;
import view.CoordenadorVerEditais;
import view.ModeloJanelaComTabela;
import view.TelaCadastrarEditalCoordenador;

public class TransicaoDeJanelasCoordenadorController {
	
	private CoordenadorVerEditais janelaVerEditais;
	
	public void abrirTelaDeListarAlunos() {

	}
	
	public void abrirTelaDeListarEditais() {
		
		janelaVerEditais.dispose();
		new CoordenadorVerEditais();
	}

	public void abrirTelaDeCadastroDeEdital() {
	
		janelaVerEditais.dispose();
		// abrir tela de cadastro de edital
	}
	


	public CoordenadorVerEditais getJanelaVerEditais() {
		return janelaVerEditais;
	}

	public void setJanelaVerEditais(CoordenadorVerEditais janelaVerEditais) {
		this.janelaVerEditais = janelaVerEditais;
	}


}
