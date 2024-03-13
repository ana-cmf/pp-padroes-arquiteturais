package dao;

import java.time.LocalDateTime;

import dto.EditalDeMonitoriaDTO;

public interface IEditalDeMonitoriaDAO {
	
	public void reabrirEdital();	
	
	public EditalDeMonitoriaDTO clone();
	
	public void criarNovoEdital(LocalDateTime dataInicio, LocalDateTime dataFinal, String disciplina, int quantidadeDeVagas, float pesoCRE, float pesoNotaAluno);
	

}
