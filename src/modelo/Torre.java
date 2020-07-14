package modelo;

public class Torre extends Ficha {

	
	public Torre(Coordenada c, int color) {
		super(c, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Tablero board, Coordenada start, Coordenada end) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
