package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.PersistenciaCoordenador;
import dto.CoordenadorDTO;
import view.TelaCadastroCoordenador;

public class CadastroCoordenadorController {

	private PersistenciaCoordenador coordenadorDAO;
	private TelaCadastroCoordenador janelaDeCadastro;
	
	public void salvarCoordenador(CoordenadorDTO coordenadorDTO) {
		
		coordenadorDAO.cadastrarCoordenador(coordenadorDTO);
	}
	
	public CoordenadorDTO procurarCoordenador() {
		
		return coordenadorDAO.buscarCoordenador();
	}
	
	public boolean validarEmail(String email) {
		String regex = "^[a-zA-Z]+\\.[a-zA-Z]+@ifpb\\.edu\\.br$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public boolean algumCampoEstaEmBranco() {
		return janelaDeCadastro.getNome().getText().isBlank() ||
			   janelaDeCadastro.getSobrenome().getText().isBlank() ||
			   janelaDeCadastro.getEmail().getText().isBlank() ||
			   janelaDeCadastro.getConfirmarEmail().getText().isBlank() ||
		      (janelaDeCadastro.getSenha().getPassword().length < 8) ||
		      (janelaDeCadastro.getConfirmarSenha().getPassword().length < 8);
	
	}

	public PersistenciaCoordenador getCoordenadorDAO() {
		return coordenadorDAO;
	}
	
	public void setCoordenadorDAO(PersistenciaCoordenador coordenadorDAO) {
		this.coordenadorDAO = coordenadorDAO;
	}
}
