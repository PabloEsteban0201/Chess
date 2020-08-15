package modelo;

public class Jugador { 
	
	private String name;
	
	public boolean white=false;
	
	public Jugador(String name,boolean white) {
		this.name=name;
		this.white=white;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWhite() {
		return white;
	}

	public void setWhite(boolean white) {
		this.white = white;
	}
	
	
} 



