package modelo.fichas;

import modelo.Coordenada;
import modelo.Tablero;

public class Torre extends Ficha {

	
	public Torre(Coordenada c, int color) {
		super(c, color);
		if(color == Ficha.BLANCO) {
			this.strRep ="WTo";
		}else {
			this.strRep="BTo";
		}
	}

	public void buscarMovimientos(Tablero board) {
		//IF para TORRES blancas else negras
		if(this.color==Ficha.BLANCO) {
			//TORRE BLANCA
			//Movimiento en linea recta hacia arriba |
			this.movLinArri(board, BLANCO);
			//Movimiento en linea recta hacia abajo
			this.movLinAba(board, BLANCO);
			//Movimiento en linea recta horizontal derecha
			this.movLinDer(board, BLANCO);
			//Movimiento en linea recta horizontal izquierda
			this.movLinIzq(board, BLANCO);
			//============================================
		}else {
			//TORRES NEGRAS
			//Movimiento en linea recta hacia arriba |
			this.movLinArri(board, NEGRO);
			//Movimiento en linea recta hacia abajo
			this.movLinAba(board, NEGRO);
			//Movimiento en linea recta horizontal derecha
			this.movLinDer(board, NEGRO);
			//Movimiento en linea recta horizontal izquierda
			this.movLinIzq(board, NEGRO);
			//============================================
		}
	}
}
