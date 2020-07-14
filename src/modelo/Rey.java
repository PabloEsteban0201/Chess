package modelo;

public class Rey extends Ficha { 
	
	public Rey(Coordenada c, int color) {
		super(c, color);
		// TODO Auto-generated constructor stub
	}

	private boolean castlingDone = false; 

	
	public boolean isCastlingDone() 
	{ 
		return this.castlingDone == true; 
	} 

	public void setCastlingDone(boolean castlingDone) 
	{ 
		this.castlingDone = castlingDone; 
	} 
	
	public Movimiento move() {
		
		
		
		return null;
		
	}
	
	@Override
	public boolean canMove(Tablero board, Coordenada start, Coordenada end) 
	{ 
		// we can't move the piece to a Spot that 
		// has a piece of the same color 
		if (end.getPiece().isWhite() == this.isWhite()) { 
			return false; 
		} 

		int x = Math.abs(start.getX() - end.getX()); 
		int y = Math.abs(start.getY() - end.getY()); 
		if (x + y == 1) { 
			// check if this move will not result in the king 
			// being attacked if so return true 
			return true; 
		} 

		return this.isValidCastling(board, start, end); 
	} 

	private boolean isValidCastling(Tablero board, 
									Coordenada start, Coordenada end) 
	{ 

		if (this.isCastlingDone()) { 
			return false; 
		}else {
			return true;
		}
		

		// Logic for returning true or false 
	} 

	public boolean isCastlingMove(Coordenada start, Coordenada end) 
	{ 
		// check if the starting and 
		// ending position are correct 
	} 
} 

