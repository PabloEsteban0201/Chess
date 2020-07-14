package modelo;

public class Caballo extends Ficha { 
	 
	public Caballo(Coordenada c, int color) {
		super(c, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Tablero board, Coordenada start, 
											Coordenada end) 
	{ 
		// we can't move the piece to a spot that has 
		// a piece of the same colour 
		if (end.getPiece().isWhite() == this.isWhite()) { 
			return false; 
		} 

		int x = Math.abs(start.getX() - end.getX()); 
		int y = Math.abs(start.getY() - end.getY()); 
		return x * y == 2; 
	} 
} 
