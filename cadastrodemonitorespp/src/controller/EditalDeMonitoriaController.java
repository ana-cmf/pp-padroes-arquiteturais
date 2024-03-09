package controller;

import dto.EditalDeMonitoriaDTO;
import model.EditalDeMonitoria;

public class EditalDeMonitoriaController {

	private EditalDeMonitoria edital;
	
	public void encerrarEditalAntesDoTempo(EditalDeMonitoriaDTO editalDTO) {
		//passar dados do dto para o edital
		edital.encerrarEditalAntesDoTempo();
	}
	
	public void clonarEdital() {
		edital.clone();
	}
}
