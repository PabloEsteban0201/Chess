package modelo.fichas;

import modelo.Coordenada;
import modelo.Movimiento;
import modelo.Tablero;

public class Caballo extends Ficha { 
	 
	public Caballo(Coordenada c, int color) {
		super(c, color);
		// TODO Auto-generated constructor stub
		if(color == Ficha.BLANCO) {
			this.strRep ="WKn";
		}else {
			this.strRep="Bkn";
		}
	}

	@Override
	public void buscarMovimientos(Tablero board) {
		int x;
		int y;
		if(this.color==Ficha.BLANCO) {
			//Caballo BLANCO
			//SALTO ARRIBA DERECHA VERTICAL
			x=this.getPosicion().getX();
			y=this.getPosicion().getY();
			if(x+1<=7 && x+1>=0 && y-2<=7 && y-2>=0){
				if(board.estaVacio(x+1, y-2)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y-2),false));
				}else if(board.getColorFicha(x+1, y-2)==Ficha.NEGRO && x+1<=7 && x+1>=0
						&& y-2<=7 && y-2>=0){
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y-2),true));
				}
			}
			//SALTO ARRIBA DERECHA HORIZONTAL
			if(x+2<=7 && x+2>=0 && y-1<=7 && y-1>=0){
				if(board.estaVacio(x+2, y-1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+2,y-1),false));
				}else if(board.getColorFicha(x+2, y-1)==Ficha.NEGRO && x+2<=7 && x+2>=0
						&& y-1<=7 && y-1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+2,y-1),true));
				}
			}
			//SALTO ARRIBA IZQUIERDA VERTICAL
			if(x-1<=7 && x-1>=0 && y-2<=7 && y-2>=0){
				if(board.estaVacio(x-1, y-2)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y-2),false));
				}else if(board.getColorFicha(x-1, y-2)==Ficha.NEGRO && x-1<=7 && x-1>=0
						&& y-2<=7 && y-2>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y-2),true));
				}	
			}
			//SALTO ARRIBA IZQUIERDA HORIZONTAL
			if(x-2<=7 && x-2>=0 && y-1<=7 && y-1>=0){
				if(board.estaVacio(x-2, y-1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-2,y-1),false));
				}else if(board.getColorFicha(x-2, y-1)==Ficha.NEGRO && x-2<=7 && x-2>=0
						&& y-1<=7 && y-1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-2,y-1),true));
				}
				
			}
			//SALTO ABAJO DERECHA HORIZONTAL
			if(x+2<=7 && x+2>=0 && y+1<=7 && y+1>=0){
				if(board.estaVacio(x+2, y+1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+2,y+1),false));
				}else if(board.getColorFicha(x+2, y+1)==Ficha.NEGRO && x+2<=7 && x+2>=0
						&& y+1<=7 && y+1>=0){
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+2,y+1),true));
				}	
			}
			//SALTO ABAJO DERECHA VERTICAL L
			if(x+1<=7 && x+1>=0 && y+2<=7 && y+2>=0){
				if(board.estaVacio(x+1, y+2)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y+2),false));
				}else if(board.getColorFicha(x+1, y+2)==Ficha.NEGRO && x+1<=7 && x+1>=0
						&& y+2<=7 && y+2>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y+2),true));
				}	
			}
			//SALTO ABAJO IZQUIERDA VERTICAL 
			if(x-1<=7 && x-1>=0 && y+2<=7 && y+2>=0){
				if(board.estaVacio(x-1, y+2)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y+2),false));
				}else if(board.getColorFicha(x-1, y+2)==Ficha.NEGRO && x-1<=7 && x-1>=0
						&& y+2<=7 && y+2>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y+2),true));
				}
				
			}
			//SALTO ABAJO IZQUIERDA HORIZONTAL
			if(x-2<=7 && x-2>=0 && y+1<=7 && y+1>=0){
				if(board.estaVacio(x-2, y+1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-2,y+1),false));
				}else if(board.getColorFicha(x-2, y+1)==Ficha.NEGRO && x-2<=7 && x-2>=0
						&& y+1<=7 && y+1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-2,y+1),true));
				}	
			}
		}else {
			//CABALLO NEGRO
			//SALTO ARRIBA DERECHA VERTICAL
			x=this.getPosicion().getX();
			y=this.getPosicion().getY();
			if(x+1<=7 && x+1>=0 && y-2<=7 && y-2>=0){
				if(board.estaVacio(x+1, y-2)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y-2),false));
				}else if(board.getColorFicha(x+1, y-2)==Ficha.BLANCO && x+1<=7 && x+1>=0
						&& y-2<=7 && y-2>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y-2),true));
				}
				
			}
			//SALTO ARRIBA DERECHA HORIZONTAL
			if(x+2<=7 && x+2>=0 && y-1<=7 && y-1>=0){
				if(board.estaVacio(x+2, y-1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+2,y-1),false));
				}else if(board.getColorFicha(x+2, y-1)==Ficha.BLANCO && x+2<=7 && x+2>=0
						&& y-1<=7 && y-1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+2,y-1),true));
				}
				
			}
			//SALTO ARRIBA IZQUIERDA VERTICAL
			if(x-1<=7 && x-1>=0 && y-2<=7 && y-2>=0){
				if(board.estaVacio(x-1, y-2)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y-2),false));
				}else if(board.getColorFicha(x-1, y-2)==Ficha.BLANCO && x-1<=7 && x-1>=0
						&& y-2<=7 && y-2>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y-2),true));
				}
				
			}
			//SALTO ARRIBA IZQUIERDA HORIZONTAL
			if(x-2<=7 && x-2>=0 && y-1<=7 && y-1>=0){
				if(board.estaVacio(x-2, y-1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-2,y-1),false));
				}else if(board.getColorFicha(x-2, y-1)==Ficha.BLANCO && x-2<=7 && x-2>=0
						&& y-1<=7 && y-1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-2,y-1),true));
				}
				
			}
			//SALTO ABAJO DERECHA HORIZONTAL
			if(x+2<=7 && x+2>=0 && y+1<=7 && y+1>=0){
				if(board.estaVacio(x+2, y+1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+2,y+1),false));
				}else if(board.getColorFicha(x+2, y+1)==Ficha.BLANCO && x+2<=7 && x+2>=0
						&& y+1<=7 && y+1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+2,y+1),true));
				}
				
			}
			//SALTO ABAJO DERECHA VERTICAL L
			if(x+1<=7 && x+1>=0 && y+2<=7 && y+2>=0){
				if(board.estaVacio(x+1, y+2)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y+2),false));
				}else if(board.getColorFicha(x+1, y+2)==Ficha.BLANCO && x+1<=7 && x+1>=0
						&& y+2<=7 && y+2>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y+2),true));
				}
				
			}
			//SALTO ABAJO IZQUIERDA VERTICAL 
			if(x-1<=7 && x-1>=0 && y+2<=7 && y+2>=0){
				if(board.estaVacio(x-1, y+2)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y+2),false));
				}else if(board.getColorFicha(x-1, y+2)==Ficha.BLANCO && x-1<=7 && x-1>=0
						&& y+2<=7 && y+2>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y+2),true));
				}
				
			}
			//SALTO ABAJO IZQUIERDA HORIZONTAL
			if(x-2<=7 && x-2>=0 && y+1<=7 && y+1>=0){
				if(board.estaVacio(x-2, y+1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-2,y+1),false));
				}else if(board.getColorFicha(x-2, y+1)==Ficha.BLANCO && x-2<=7 && x-2>=0
						&& y+1<=7 && y+1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-2,y+1),true));
				}	
			}
		}
	}

	
} 
