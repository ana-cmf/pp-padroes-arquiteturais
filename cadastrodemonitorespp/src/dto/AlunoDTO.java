package dto;

public class AlunoDTO extends UsuarioDTO {

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
}

