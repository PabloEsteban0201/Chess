package modelo;

public class Movimiento { 
	private Jugador player; 
	private Coordenada start; 
	private Coordenada end; 
	private Ficha pieceMoved; 
	private Ficha pieceKilled; 
	private boolean castlingMove = false; 

	public Movimiento(Jugador player, Coordenada start, Coordenada end) 
	{ 
		this.player = player; 
		this.start = start; 
		this.end = end; 
		this.pieceMoved = start.getPiece(); 
	} 

	public boolean isCastlingMove() 
	{ 
		return this.castlingMove == true; 
	} 

	public void setCastlingMove(boolean castlingMove) 
	{ 
		this.castlingMove = castlingMove; 
	} 
} 
