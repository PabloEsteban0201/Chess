package modelo;

import modelo.fichas.Ficha;
import modelo.fichas.Rey;

public class Juego { 
	private Jugador[] players; 
	private Tablero board; 
	private Jugador currentTurn; 
	private GameStatus status; 


	private void initialize(Jugador p1, Jugador p2) 
	{ 
		players[0] = p1; 
		players[1] = p2; 

		board.resetBoard(); 

		if (p1.white) { 
			this.currentTurn = p1; 
		} 
		else { 
			this.currentTurn = p2; 
		} 

	} 

	
} 

