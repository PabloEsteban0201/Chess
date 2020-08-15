package modelo.fichas;

import modelo.Coordenada;
import modelo.Tablero;

public class Reina extends Ficha{

	public Reina(Coordenada c, int color) {
		super(c, color);
		if(color == Ficha.BLANCO) {
			this.strRep ="WQu";
		}else {
			this.strRep="BQu";
		}
	}
	
	
	@Override
	public void buscarMovimientos(Tablero board) {
		//IF para fichas blancas else negras
		if(this.color==Ficha.BLANCO) {
			//REINA BLANCA
			//Movimiento en diagonal derecha arriba
			this.movDiagDerArri(board, Ficha.BLANCO);
			//Movimiento en diagonal izquierda arriba
			this.movDiagIzqArri(board, BLANCO);
			//Movimiento en diagonal derecha abajo
			this.movDiagDerAba(board, BLANCO);
			//Movimiento en diagonal izquierda abajo
			this.movDiagIzqAba(board, BLANCO);
			//Movimiento en linea recta hacia arriba |
			this.movLinArri(board, BLANCO);
			//Movimiento en linea recta hacia abajo
			this.movLinAba(board, BLANCO);
			//Movimiento en linea recta horizontal derecha
			this.movLinDer(board, BLANCO);
			//Movimiento en linea recta horizontal izquierda
			this.movLinIzq(board, BLANCO);
			//========================================
			
		}else {
			//Reina NEGRA---------------------------
			//Movimiento en diagonal derecha arriba
			this.movDiagDerArri(board, NEGRO);
			//Movimiento en diagonal izquierda arriba
			this.movDiagIzqArri(board, NEGRO);
			//Movimiento en diagonal derecha abajo
			this.movDiagDerAba(board, NEGRO);
			//Movimiento en diagonal izquierda abajo
			this.movDiagIzqAba(board, NEGRO);
			//Movimiento en linea recta hacia arriba |
			this.movLinArri(board, NEGRO);
			//Movimiento en linea recta hacia abajo
			this.movLinAba(board, NEGRO);
			//Movimiento en linea recta horizontal derecha
			this.movLinDer(board, NEGRO);
			//Movimiento en linea recta horizontal izquierda
			this.movLinIzq(board, NEGRO);
			//========================================
			//END===========================================
		}
	}

    

}