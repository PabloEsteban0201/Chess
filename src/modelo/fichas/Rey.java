package modelo.fichas;

import modelo.Coordenada;
import modelo.Movimiento;
import modelo.Tablero;

public class Rey extends Ficha { 
	
	private boolean castlingDone = false;
	
	public Rey(Coordenada c, int color) {
		super(c, color);
		if(color == Ficha.BLANCO) {
			this.strRep ="WKi";
		}else {
			this.strRep="BKi";
		}
	}

	public void buscarMovimientos(Tablero board) {
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		
		//El if es para EL REY BLANCO
		if(this.color==Ficha.BLANCO) {
			//REY BLANCO
			//Movimiento ARRIBA
			if(y-1<=7 && y-1>=0){
				if(board.estaVacio(x,y-1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x,y-1),false));
				}else if(board.getColorFicha(x, y-1)==Ficha.NEGRO && y-1<=7 && y-1>=0) {//SÍ HAY FICHA NEGRA
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x,y-1),true));
				}
			}
			//MOVIMIENTO ABAJO
			if(y+1<=7 && y+1>=0){
				if(board.estaVacio(x,y+1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x,y+1),false));
				}else if(board.getColorFicha(x, y+1)==Ficha.NEGRO && y+1<=7 && y+1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x,y+1),true));
				}
				
			}
			//MOVIMIENTO IZQUIERDA
			if(x-1<=7 && x-1>=0){
				if(board.estaVacio(x-1,y)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y),false));
				}else if(board.getColorFicha(x-1, y)==Ficha.NEGRO && x-1<=7 && x-1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y),true));
				}	
			}
			//MOVIMIENTO DERECHA
			if(x+1<=7 && x+1>=0){
				if(board.estaVacio(x+1,y)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y),false));
				}else if(board.getColorFicha(x+1, y)==Ficha.NEGRO && x+1<=7 && x+1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y),true));
				} 				
			}
		}else {
			//REY NEGRO
			//Movimiento ARRIBA
			if(y-1<=7 && y-1>=0){
				if(board.estaVacio(x,y-1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x,y-1),false));
				}else if(board.getColorFicha(x, y-1)==Ficha.BLANCO && y-1<=7 && y-1>=0) {//SÍ HAY FICHA NEGRA
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x,y-1),true));
				}
			}
			//MOVIMIENTO ABAJO
			if(y+1<=7 && y+1>=0){
				if(board.estaVacio(x,y+1)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x,y+1),false));
				}else if(board.getColorFicha(x, y+1)==Ficha.BLANCO && y+1<=7 && y+1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x,y+1),true));
				}
				
			}
			//MOVIMIENTO IZQUIERDA
			if(x-1<=7 && x-1>=0){
				if(board.estaVacio(x-1,y)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y),false));
				}else if(board.getColorFicha(x-1, y)==Ficha.BLANCO && x-1<=7 && x-1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x-1,y),true));
				}	
			}
			//MOVIMIENTO DERECHA
			if(x+1<=7 && x+1>=0){
				if(board.estaVacio(x+1,y)) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y),false));
				}else if(board.getColorFicha(x+1, y)==Ficha.BLANCO && x+1<=7 && x+1>=0) {
					this.listMovs.add(new Movimiento(this.getPosicion(), 
							new Coordenada(x+1,y),true));
				} 				
			}
			
		}
	}
	
	
	public boolean isCastlingDone() 
	{ 
		return this.castlingDone == true; 
	} 
	
	

	public void setCastlingDone(boolean castlingDone) 
	{ 
		this.castlingDone = castlingDone; 
	} 
	
	
	 

	
} 

