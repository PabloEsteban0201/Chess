package modelo;

public abstract class Ficha { 
	
	public static int NEGRO = 1;
	
	public static int BLANCO = 2;
	
	protected int color;
	
	protected String strRep;
	
	protected Coordenada posicion;

	

	public Ficha(Coordenada c, int color) 
	{ 
		posicion = c;
		this.color = color;
	} 


	public Coordenada getPosicion() {
		return posicion;
	}

	public void setPosicion(Coordenada posicion) {
		this.posicion = posicion;
	}
	public abstract boolean canMove(Tablero board, 
								Coordenada start, Coordenada end);
	
} 

