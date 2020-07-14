package modelo;

public class Peon extends Ficha {
	
	public Peon(Coordenada c, int color) {
		super(c, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Tablero board, Coordenada start, Coordenada end) {
		// TODO Auto-generated method stub
		return false;
	}

}
