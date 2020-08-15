package modelo.fichas;

import modelo.Coordenada;
import modelo.Movimiento;
import modelo.Tablero;

public class Peon extends Ficha {
	
	private boolean priMov=true;
	
	public Peon(Coordenada c, int color) {
		super(c, color);
		if(color == Ficha.BLANCO) {
			this.strRep ="WPw";
		}else {
			this.strRep="BPw";
		}
	}
	
	
	@Override
	public void buscarMovimientos(Tablero board) {
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		this.primerMovimiento();
		//The if is for the white pawns
		//El if es para los peones blancos
		if(this.color==Ficha.BLANCO) {
			if(priMov==true) {
				//Revisa el primer movimiento al sumar 2
				if(x<=7 && x>=0 && y-2<=7 && y-2>=0) {
					if(board.estaVacio(x,y-2)) {
						this.listMovs.add(new Movimiento(this.getPosicion(), 
								new Coordenada(x,y-2),false));
					}
				}
			}else {
				//Movimiento normal del peon
				if(x<=7 && x>=0 && y-1<=7 && y-1>=0){
					if(board.estaVacio(x,y-1)) {
						this.listMovs.add(new Movimiento(this.getPosicion(), 
								new Coordenada(x,y-1),false));
					}	
				}
				//Captura de la derecha
				if(!board.estaVacio(x+1, y-1)) {
					if(board.getColorFicha(x+1, y-1)==Ficha.NEGRO && x+1<=7 && x+1>=0
							&& y-1<=7 && y-1>=0){
						this.listMovs.add(new Movimiento(this.getPosicion(),new Coordenada(x+1,y-1),true));
						
					}
				}
				//Captura de la izquierda
				if(!board.estaVacio(x-1, y-1)) {
					if(board.getColorFicha(x-1, y-1)==Ficha.NEGRO && x-1<=7 && x-1>=0
							&& y-1<=7 && y-1>=0) {
						this.listMovs.add(new Movimiento(this.getPosicion(),new Coordenada(x-1,y-1),true));
					}
				}
			}
		}else {//Peones negros
			if(priMov==true) {
				//Revisa el primer movimiento al sumar 2
				if(x<=7 && x>=0 && y+2<=7 && y+2>=0) {
					if(board.estaVacio(x, y+2)) {
						this.listMovs.add(new Movimiento(this.getPosicion(), 
								new Coordenada(x,y+2),false));
					}
				}
			}else {
				//Movimiento normal del peon
				if(x<=7 && x>=0 && y+1<=7 && y+1>=0){
					if(board.estaVacio(x,y+1)) {
						this.listMovs.add(new Movimiento(this.getPosicion(), 
								new Coordenada(x,y+1),false));
					}	
				}
				//Captura de la derecha
				if(!board.estaVacio(x+1, y+1)) {
					if(board.getColorFicha(x+1, y+1)==Ficha.NEGRO && x+1<=7 && x+1>=0
							&& y+1<=7 && y+1>=0){
						this.listMovs.add(new Movimiento(this.getPosicion(),new Coordenada(x+1,y+1),true));
						
					}
				}
				//Captura de la izquierda
				if(!board.estaVacio(x-1, y+1)) {
					if(board.getColorFicha(x-1, y+1)==Ficha.NEGRO && x-1<=7 && x-1>=0
							&& y+1<=7 && y+1>=0) {
						this.listMovs.add(new Movimiento(this.getPosicion(),new Coordenada(x-1,y+1),true));
					}
				}
			}
		}
	}
	
	public void primerMovimiento() {
		if(this.color==Ficha.BLANCO) {
			if(this.getPosicion().getY()==6) {
				priMov=true;
			}else {
				priMov=false;
			}
		}else {
			if(this.getPosicion().getY()==1) {
				priMov=true;
			}else {
				priMov=false;
			}
		}
	}

}
