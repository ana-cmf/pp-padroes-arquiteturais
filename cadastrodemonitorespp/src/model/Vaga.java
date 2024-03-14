package model;

import java.util.ArrayList;

import dto.AlunoDTO;
import dto.EditalDeMonitoriaDTO;
import dto.VagaDTO;

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
	
	public static Vaga fromDTO(VagaDTO dto) {
		Vaga edital = new Vaga();
		edital.setDisciplina(dto.getDisciplina());
		edital.setQuantidadeDeVagas(dto.getQuantidadeDeVagas());
		
		
		return edital;
	}
	
	public VagaDTO toDTO() {
        VagaDTO dto = new VagaDTO();
        dto.setDisciplina(this.disciplina);
        dto.setQuantidadeDeVagas(this.quantidadeDeVagas);

        return dto;
    }		
}
