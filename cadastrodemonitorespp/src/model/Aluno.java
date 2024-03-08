package model;

public class Aluno extends Usuario{
	
	private String matricula;
	private float CRE;
	private int nota;
	private float mediaPonderada;
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public float getCRE() {
		return CRE;
	}

	public void setCRE(float cRE) {
		CRE = cRE;
	}
	
	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public float calcularMedia(float pesoCRE, float pesoNota) {
		return CRE*pesoCRE + nota*pesoNota;
	}
	
	public int compareTo(Object o) {
		Aluno aluno = (Aluno) o;
		if (mediaPonderada > aluno.getMediaPonderada()) {
			return 1;
		} else if (mediaPonderada < aluno.getMediaPonderada()) {
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		String infoAluno = getNome()+" "+getSobrenome()+"\n"+
						getEmail()+"\n"+
						"Matricula "+getMatricula()+"\n";
		return infoAluno;
	}

	
	public float getMediaPonderada() {
		return mediaPonderada;
	}
	
	public void setMediaPonderada(float mediaPonderada) {
		this.mediaPonderada = mediaPonderada;
	}


}
