package modelo;

public class Tablero { 
	public static int ALTURA = 8;
	
	public static int ANCHO = 8;
	
	private final Ficha boardGame[][] = new Ficha[ALTURA][ANCHO];

	public Tablero() 
	{ 
		this.resetBoard(); 
	} 

	public void resetBoard() 
	{ 
		// initialize white pieces 
		boardGame[0][0] = new Torre(new Coordenada(0,0),Ficha.BLANCO); 
		boardGame[0][1] = new Caballo(new Coordenada(0,1),Ficha.BLANCO); 
		boardGame[0][2] = new Alfil(new Coordenada(0,2),Ficha.BLANCO);
		boardGame[0][3] = new Reina(new Coordenada(0,3),Ficha.BLANCO); 
		boardGame[0][4] = new Rey(new Coordenada(0,4),Ficha.BLANCO); 
		boardGame[0][5] = new Alfil(new Coordenada(0,5),Ficha.BLANCO);
		boardGame[0][6] = new Caballo(new Coordenada(0,6),Ficha.BLANCO);
		boardGame[0][7] = new Torre(new Coordenada(0,7),Ficha.BLANCO);
		//... 
		for(int i=0;i<ANCHO;i++) {
			boardGame[1][i] = new Peon(new Coordenada(1,i),Ficha.BLANCO); 
		}
		
		//... 

		// initialize black pieces 
		boardGame[7][0] = new Torre(new Coordenada(7,0),Ficha.NEGRO); 
		boardGame[7][1] = new Caballo(new Coordenada(7,1),Ficha.NEGRO); 
		boardGame[7][2] = new Alfil(new Coordenada(7,2),Ficha.NEGRO);
		boardGame[7][3] = new Reina(new Coordenada(7,3),Ficha.NEGRO); 
		boardGame[7][4] = new Rey(new Coordenada(7,4),Ficha.NEGRO); 
		boardGame[7][5] = new Alfil(new Coordenada(7,5),Ficha.NEGRO);
		boardGame[7][6] = new Caballo(new Coordenada(7,6),Ficha.NEGRO);
		boardGame[7][7] = new Torre(new Coordenada(7,7),Ficha.NEGRO);
		//... 
		for(int i=0;i<ANCHO;i++) {
			boardGame[6][i] = new Peon(new Coordenada(6,i),Ficha.NEGRO); 
		} 
		//... 

		// initialize remaining boxes without any piece 
		for (int i = 2; i < 6; i++) { 
			for (int j = 0; j < 8; j++) { 
				boardGame[i][j] = null; 
			} 
		} 
	}
	
	public void borrarFicha(Coordenada c) {
		if(boardGame[c.getY()][c.getX()]!=null) {
			boardGame[c.getY()][c.getX()]=null;
		}
		
	}
	
	public Ficha getFichaTablero(Coordenada c) {
        return boardGame[c.getY()][c.getX()];
    }

    public void setFichaTablero(Ficha ficha, Coordenada c) {
        boardGame[c.getY()][c.getX()] = ficha;
        ficha.setPosicion(c);
    }

	public Ficha[][] getBoardGame() {
		return boardGame;
	} 
} 
