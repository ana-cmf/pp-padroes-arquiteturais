package dto;

import java.util.ArrayList;

public class VagaDTO {

	private String disciplina;
	private int quantidadeDeVagas;
	private ArrayList<AlunoDTO> listaDeAlunosInscritos = new ArrayList<AlunoDTO>();
	private ArrayList<AlunoDTO> listaDeAlunosAprovados = new ArrayList<AlunoDTO>();
	public String getDisciplina() {
		return disciplina;
	} 
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public int getQuantidadeDeVagas() {
		return quantidadeDeVagas;
	}
	public void setQuantidadeDeVagas(int quantidadeDeVagas) {
		this.quantidadeDeVagas = quantidadeDeVagas;
	}
	public ArrayList<AlunoDTO> getListaDeAlunosInscritos() {
		return listaDeAlunosInscritos;
	}
	public void setListaDeAlunosInscritos(ArrayList<AlunoDTO> listaDeAlunosInscritos) {
		this.listaDeAlunosInscritos = listaDeAlunosInscritos;
	}
	public ArrayList<AlunoDTO> getListaDeAlunosAprovados() {
		return listaDeAlunosAprovados;
	}
	public void setListaDeAlunosAprovados(ArrayList<AlunoDTO> listaDeAlunosAprovados) {
		this.listaDeAlunosAprovados = listaDeAlunosAprovados;
	}


}
