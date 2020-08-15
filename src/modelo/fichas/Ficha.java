package modelo.fichas;

import java.util.ArrayList;

import modelo.Coordenada;
import modelo.Movimiento;
import modelo.Tablero;

public abstract class Ficha { 
	
	public static int NEGRO = 1;
	
	public static int BLANCO = 2;
	
	protected int color;
	
	protected String strRep;
	
	protected Coordenada posicion;
	
	protected ArrayList<Movimiento> listMovs = new ArrayList<>(); 
	
	
	public abstract void buscarMovimientos(Tablero board);
	
	/**
	 * Method for move a piece
	 * @param x is the end position in the x axis
	 * @param y is the end position in the y axis
	 * @return true if is a capture move
	 */
	public boolean mover(int x, int y, Tablero t) {
		boolean capture=false;
		int iX=0,iY=0;
		iX=this.fichaX();
		iY=this.fichaY();
		
		for(int i=0;i<this.listMovs.size();i++) {
			if(this.listMovs.get(i).getEnd().getX()==x &&
					this.listMovs.get(i).getEnd().getY()==y) {
				if(this.listMovs.get(i).isCapture()) {//If there is capture
					t.borrarFicha(new Coordenada(x,y));
					t.setFichaTablero(this,new Coordenada(x,y));
					this.setPosicion(new Coordenada(x,y));
					t.borrarFicha(new Coordenada(iX,iY));
					capture= true;
				}else {
					t.setFichaTablero(this,new Coordenada(x,y));
					this.setPosicion(new Coordenada(x,y));
					t.borrarFicha(new Coordenada(iX,iY));
					capture= false;
				}
			}
		}
		
		return capture;
	}
	
	public void showMovesToString() {
		int xI;
		int xF;
		char letraI='A';
		char letraF='A';
		for(int i=0;i<listMovs.size();i++) {
			xI=listMovs.get(i).getStart().getX();
			xF=listMovs.get(i).getEnd().getX();
			switch(xI){
			case 0:
				letraI='A';
				break;
			case 1:
				letraI='B';
				break;
			case 2:
				letraI='C';
				break;
			case 3:
				letraI='D';
				break;
			case 4:
				letraI='E';
				break;
			case 5:
				letraI='F';
				break;
			case 6:
				letraI='G';
				break;
			case 7:
				letraI='H';
				break;
			default:
				System.out.println("Erro en ingreso");
			}
			switch(xF){
			case 0:
				letraF='A';
				break;
			case 1:
				letraF='B';
				break;
			case 2:
				letraF='C';
				break;
			case 3:
				letraF='D';
				break;
			case 4:
				letraF='E';
				break;
			case 5:
				letraF='F';
				break;
			case 6:
				letraF='G';
				break;
			case 7:
				letraF='H';
				break;
			default:
				System.out.println("Erro en ingreso");
			}
			System.out.print("Inicial:"+letraI+
					(8-listMovs.get(i).getStart().getY()));
			
			System.out.print("--Final:"+letraF+(8-listMovs.get(i).getEnd().getY()));
			if(listMovs.get(i).isCapture()) {
				System.out.println("--"+"Captura");	
			}else {
				System.out.println("--"+"Normal");
			}
			
		}
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public ArrayList<Movimiento> getListMovs() {
		return listMovs;
	}


	public void setListMovs(ArrayList<Movimiento> listMovs) {
		this.listMovs = listMovs;
	}

	public Ficha(Coordenada c, int color) 
	{ 
		posicion = c;
		this.color = color;
	} 
	
	public String getStrRep() {
		return strRep;
	}



	public void setStrRep(String strRep) {
		this.strRep = strRep;
	}

	public Coordenada getPosicion() {
		return posicion;
	}

	public void setPosicion(Coordenada posicion) {
		this.posicion = posicion;
	}
	
	public int fichaX() {
		return this.getPosicion().getX();
	}
	
	public int fichaY() {
		return this.getPosicion().getY();
	}
	
	public void movDiagDerArri(Tablero b,int color) {
		//Movimiento en diagonal derecha arriba
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		boolean stop=false;
		x++;
		y--;
		while(x<7 && x>0 && y<7 && y>0 && !stop) {
			if(b.estaVacio(x, y)) {
				x++;
				y--;
			}else {
				stop=true;
			}
		}
		//Si es blanco
		if(!b.estaVacio(x, y)) {
			if(b.getColorFicha(x, y)==color){
				int i=this.fichaY();
				int j=this.fichaX();
				while(i>(y+1) && j<(x-1) ) {
					i--;
					j++;
					this.listMovs.add(new Movimiento(this.getPosicion(),new Coordenada(j,i),false));
				}
			}else {
				//Si es negro
				int i=this.fichaY();
				int j=this.fichaX();
				while(i>y && j<x ) {
					i--;
					j++;
					if(i==y && j==x) {
						this.listMovs.add(new Movimiento(this.getPosicion(),new Coordenada(j,i),true));
					}else {
						this.listMovs.add(new Movimiento(this.getPosicion(),new Coordenada(j,i),false));
					}
					
				}
			}
		}else {
			int i=this.fichaY();
			int j=this.fichaX();
			while(i>y && j<x ) {
				i--;
				j++;
				this.listMovs.add(new Movimiento(this.getPosicion(),new Coordenada(j,i),false));
			}
		}
	}
	
	public void movDiagIzqArri(Tablero b, int color) {

		
		//Movimiento en diagonal izquierda arriba
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		boolean stop=false;
		x--;
		y--;
		while(x<7 && x>0 && y<7 && y>0 && !stop) {
			if(b.estaVacio(x, y)) {
				x--;
				y--;
			}else {
				stop=true;
			}
		}
		if (!b.estaVacio(x, y)) {
			//Si es blanco
			if (b.getColorFicha(x, y) == color) {
				int i = this.fichaY();
				int j = this.fichaX();
				while (i > (y+1) && j > (x+1)) {
					i--;
					j--;
					this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
				}
			} else {
				//Si es negro
				int i = this.fichaY();
				int j = this.fichaX();
				while (i > y && j > x) {
					i--;
					j--;
					if (i == y && j == x) {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), true));
					} else {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
					}
				}
			} 
		}else {
			//SÍ TIENE LINEA LIBRE
			int i = this.fichaY();
			int j = this.fichaX();
			while (i > y && j > x) {
				i--;
				j--;
				this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
			}
		}
	}

	public void movDiagDerAba(Tablero b, int color) {
		//Movimiento en diagonal derecha abajo
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		boolean stop=false;
		x++;
		y++;
		while(x<7 && x>0 && y<7 && y>0 && !stop) {
			if(b.estaVacio(x, y)) {
				x++;
				y++;
			}else {
				stop=true;
			}
		}
		if (!b.estaVacio(x, y)) {
			//Si es blanco
			if (b.getColorFicha(x, y) == color) {
				int i = this.fichaY();
				int j = this.fichaX();
				while (i < (y-1) && j < (x-1)) {
					i++;
					j++;
					this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
				}
			} else {
				//Si es negro
				int i = this.fichaY();
				int j = this.fichaX();
				while (i < y && j < x) {
					i++;
					j++;
					if (i == y && j == x) {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), true));
					} else {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
					}
				}
			} 
		}else {
			//SI TIENE LINEA LIBRE
			int i = this.fichaY();
			int j = this.fichaX();
			while (i < y && j < x) {
				i++;
				j++;
				this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
				
			}
		}
	}
	
	public void movDiagIzqAba(Tablero b, int color) {
		//Movimiento diagonal izquierda abajo
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		boolean stop=false;
		x--;
		y++;
		while(x<7 && x>0 && y<7 && y>0 && !stop) {
			if(b.estaVacio(x, y)) {
				x--;
				y++;
			}else {
				stop=true;
			}
		}
		if (!b.estaVacio(x, y)) {
			//Si es blanco
			if (b.getColorFicha(x, y) == color) {
				int i = this.fichaY();
				int j = this.fichaX();
				while (i < (y-1) && j > (x+1)) {
					i++;
					j--;
					this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
				}
			} else {
				//Si es negro
				int i = this.fichaY();
				int j = this.fichaX();
				while (i < y && j > x) {
					i++;
					j--;
					if (i == y && j == x) {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), true));
					} else {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
					}
				}
			}
			//------------
		}else {
			//SÍ LINEA LIBRE
			int i = this.fichaY();
			int j = this.fichaX();
			while (i < y && j > x) {
				i++;
				j--;
				this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
			}
		}
	}
	
	public void movLinArri(Tablero b, int color) {
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		boolean stop=false;
		y--;
		while(y<7 && y>0 && !stop) {
			if(b.estaVacio(x, y)) {
				y--;
			}else {
				stop=true;
			}
		}
		
		if (!b.estaVacio(x, y)) {
			//Si es blanco
			if (b.getColorFicha(x, y) == color) {
				int i = this.fichaY();
				int j = this.fichaX();
				while (i > (y+1)) {
					i--;
					this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
				}
			} else {
				//Si es negro
				int i = this.fichaY();
				int j = this.fichaX();
				while (i > y) {
					i--;
					if (i == y && j == x) {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), true));
					} else {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
					}
				}
			} 
		}else {
			//SÍ TIENE LINEA LIBRE
			int i = this.fichaY();
			int j = this.fichaX();
			while (i > y) {
				i--;
				this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
			}
		}
	}
	
	public void movLinAba(Tablero b, int color) {
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		boolean stop=false;
		y++;
		while(y<7 && y>0 && !stop) {
			if(b.estaVacio(x, y)) {
				y++;
			}else {
				stop=true;
			}
		}
		if (!b.estaVacio(x, y)) {
			//Si es Blanco
			if (b.getColorFicha(x, y) == color) {
				int i = this.fichaY();
				int j = this.fichaX();
				while (i < (y-1)) {
					i++;
					this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
				}
			} else {
				//Si es Negro
				int i = this.fichaY();
				int j = this.fichaX();
				while (i < y) {
					i++;
					if (i == y && j == x) {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), true));
					} else {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
					}
				}
			} 
		}else {
			int i = this.fichaY();
			int j = this.fichaX();
			while (i < y) {
				i++;
				this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
			}
		}
	}
	
	public void movLinDer(Tablero b, int color) {
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		boolean stop=false;
		x++;
		while(x<7 && x>0 && !stop) {
			if(b.estaVacio(x, y)) {
				x++;
			}else {
				stop=true;
			}
		}
		if (!b.estaVacio(x, y)) {
			//Si es blanco
			if (b.getColorFicha(x, y) == color) {
				int i = this.fichaY();
				int j = this.fichaX();
				while (j < (x-1)) {
					j++;
					this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
				}
			} else {
				//Si es negro
				int i = this.fichaY();
				int j = this.fichaX();
				while (j < x) {
					j++;
					if (i == y && j == x) {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), true));
					} else {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
					}
				}
			} 
		}else {
			int i = this.fichaY();
			int j = this.fichaX();
			while (j < x) {
				j++;
				this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
			}
		}
	}
	
	public void movLinIzq(Tablero b, int color) {
		int x=this.getPosicion().getX();
		int y=this.getPosicion().getY();
		boolean stop=false;
		x--;
		while(x<7 && x>0 && !stop) {
			if(b.estaVacio(x, y) ) {
				x--;
			}else {
				stop=true;
			}
		}
		if (!b.estaVacio(x, y)) {
			//Si es blanco
			if (b.getColorFicha(x, y) == color) {
				int i = this.fichaY();
				int j = this.fichaX();
				while (j > (x+1)) {
					j--;
					this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
				}
			} else {
				//Si es negro
				int i = this.fichaY();
				int j = this.fichaX();
				while (j > x) {
					j--;
					if (i == y && j == x) {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), true));
					} else {
						this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
					}
				}
			}
		}else {
			int i = this.fichaY();
			int j = this.fichaX();
			while (j > x) {
				j--;
				this.listMovs.add(new Movimiento(this.getPosicion(), new Coordenada(j, i), false));
			}
		}
	}
} 

