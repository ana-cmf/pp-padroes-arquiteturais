package model;

import java.util.ArrayList;

public class Vaga {
	private String disciplina;
	private int quantidadeDeVagas;

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
	
	public ArrayList<Aluno> getListaDeAlunosInscritos() {
		return listaDeAlunosInscritos;
	}
	public void setListaDeAlunosInscritos(ArrayList<Aluno> listaDeAlunosInscritos) {
		this.listaDeAlunosInscritos = listaDeAlunosInscritos;
	}

	public ArrayList<Aluno> getListaDeAlunosAprovados() {
		return listaDeAlunosAprovados;
	}

	public void setListaDeAlunosAprovados(ArrayList<Aluno> listaDeAlunosAprovados) {
		this.listaDeAlunosAprovados = listaDeAlunosAprovados;
	}
}
