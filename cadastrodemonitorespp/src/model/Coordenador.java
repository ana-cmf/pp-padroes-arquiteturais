package model;

public class Coordenador extends Usuario{

	private static Coordenador instancia;

	private Coordenador() {
	}
	
	public static Coordenador getInstancia() {
		if (instancia == null)
			instancia = new Coordenador();

		return instancia;
	}
}
