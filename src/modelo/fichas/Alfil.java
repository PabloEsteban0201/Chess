package modelo.fichas;

import modelo.Coordenada;
import modelo.Tablero;

public class Alfil extends Ficha {

	public Alfil(Coordenada c, int color) {
		super(c, color);
		if(color == Ficha.BLANCO) {
			this.strRep ="WBi";
		}else {
			this.strRep="BBi";
		}
	}
	
	
	
	@Override
	public void buscarMovimientos(Tablero board) {

		//IF para fichas blancas else negras
		if(this.color==Ficha.BLANCO) {
			//ALFILES BLANCO
			//Movimiento en diagonal derecha arriba
			this.movDiagDerArri(board, BLANCO);
			//Movimiento en diagonal izquierda arriba
			this.movDiagIzqArri(board, BLANCO);
			//Movimiento en diagonal derecha abajo
			this.movDiagDerAba(board, BLANCO);
			//Movimiento en diagonal izquierda abajo
			this.movDiagIzqAba(board, BLANCO);
			//===========================
		}else {
			//Alfiles NEGROS
			//Movimiento en diagonal derecha arriba
			this.movDiagDerArri(board, NEGRO);
			//Movimiento en diagonal izquierda arriba
			this.movDiagIzqArri(board, NEGRO);
			//Movimiento en diagonal derecha abajo
			this.movDiagDerAba(board, NEGRO);
			//Movimiento en diagonal izquierda abajo
			this.movDiagIzqAba(board, NEGRO);
			//===========================
		}
	}
}


