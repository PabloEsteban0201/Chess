package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.fichas.Alfil;
import modelo.fichas.Caballo;
import modelo.fichas.Ficha;
import modelo.fichas.Peon;
import modelo.fichas.Reina;
import modelo.fichas.Rey;
import modelo.fichas.Torre;

public class Tablero { 
	public static int ALTURA = 8;
	
	public static int ANCHO = 8;
	
	private final Ficha boardGame[][] = new Ficha[ALTURA][ANCHO];
	
	public static void main(String args[]) throws IOException {
		
		Tablero TableroJuego = new Tablero();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name1,name2;
		String pos="FF";
		int x=0,y=0;
		char letra;
		
		System.out.println(" ====================Chess===================\n");
		/*
		System.out.print("Ingrese su nombre jugador 1: ");
		name1=br.readLine();
		System.out.print("Ingrese su nombre jugador 2: ");
		name2=br.readLine();
		Jugador J1 = new Jugador(name1,true);
		Jugador J2 = new Jugador(name2, false);
		*/
		
		impimirTablero(TableroJuego);
		/*
		if(J1.isWhite()) {
			System.out.println("Juega "+J1.getName());
			
		}else {
			System.out.println("Juega "+J2.getName());
		}
		*/
		
		System.out.println("Ingrese la ficha a mover de esta forma: A1");
		pos=br.readLine();
		pos.toUpperCase();
		letra=pos.charAt(0);
		switch(letra){
			case 'A':
				x=0;
				break;
			case 'B':
				x=1;
				break;
			case 'C':
				x=2;
				break;
			case 'D':
				x=3;
				break;
			case 'E':
				x=4;
				break;
			case 'F':
				x=5;
				break;
			case 'G':
				x=6;
				break;
			case 'H':
				x=7;
				break;
			default:
				System.out.println("Erro en ingreso");
		}
		
		letra=pos.charAt(1);
		y=Character.getNumericValue(letra);
		y = (8-y); 
		if(TableroJuego.getFichaTablero(x, y)!=null) {
			TableroJuego.getFichaTablero(x, y).buscarMovimientos(TableroJuego);
			TableroJuego.getFichaTablero(x, y).showMovesToString();
		}else {
			System.out.println("Seleciono una casill vacia");
		}
		
		TableroJuego.getFichaTablero(3, 4).mover(6, 1, TableroJuego);
		
		impimirTablero(TableroJuego);
		
	}
	
	private static void impimirTablero(Tablero t) {
		System.out.println("     A    B    C    D    E    F    G    H");
		System.out.println("    ---  ---  ---  ---  ---  ---  ---  ---");
		int ind=8;
		for(int i=0;i<Tablero.ANCHO;i++) {
			System.out.print(" "+(ind)+" ");
			for(int j=0;j<Tablero.ALTURA;j++) {
				if(t.getFichaTablero(j,i)!=null) {
					System.out.print("|"+t.getFichaTablero(j,i).getStrRep()+"|");
				}else {
					System.out.print("|   |");
				}
				
			}
			System.out.println(" "+(ind)+" ");
			System.out.println("    ---  ---  ---  ---  ---  ---  ---  ---");
			ind--;
		}
		System.out.println("     A    B    C    D    E    F    G    H");
	}

	public Tablero() 
	{ 
		this.pruebaTablero();
	} 

	public void resetBoard() { 
		// initialize white pieces 
		boardGame[0][0] = new Torre(new Coordenada(0,0),Ficha.NEGRO); 
		boardGame[0][1] = new Caballo(new Coordenada(1,0),Ficha.NEGRO); 
		boardGame[0][2] = new Alfil(new Coordenada(2,0),Ficha.NEGRO);
		boardGame[0][3] = new Reina(new Coordenada(3,0),Ficha.NEGRO); 
		boardGame[0][4] = new Rey(new Coordenada(4,0),Ficha.NEGRO); 
		boardGame[0][5] = new Alfil(new Coordenada(5,0),Ficha.NEGRO);
		boardGame[0][6] = new Caballo(new Coordenada(6,0),Ficha.NEGRO);
		boardGame[0][7] = new Torre(new Coordenada(7,0),Ficha.NEGRO);
		//... 
		for(int i=0;i<ANCHO;i++) {
			boardGame[1][i] = new Peon(new Coordenada(i,1),Ficha.NEGRO); 
		}

		//... 

		// initialize black pieces 
		boardGame[7][0] = new Torre(new Coordenada(0,7),Ficha.BLANCO); 
		boardGame[7][1] = new Caballo(new Coordenada(1,7),Ficha.BLANCO); 
		boardGame[7][2] = new Alfil(new Coordenada(2,7),Ficha.BLANCO);
		boardGame[7][3] = new Reina(new Coordenada(3,7),Ficha.BLANCO); 
		boardGame[7][4] = new Rey(new Coordenada(4,7),Ficha.BLANCO); 
		boardGame[7][5] = new Alfil(new Coordenada(5,7),Ficha.BLANCO);
		boardGame[7][6] = new Caballo(new Coordenada(6,7),Ficha.BLANCO);
		boardGame[7][7] = new Torre(new Coordenada(7,7),Ficha.BLANCO);
		
		//...
		for(int i=0;i<ANCHO;i++) {
			boardGame[6][i] = new Peon(new Coordenada(i,6),Ficha.BLANCO); 
		}  

		// initialize remaining boxes without any piece 
		for (int i = 2; i < 6; i++) { 
			for (int j = 0; j < 8; j++) { 
				boardGame[i][j] = null; 
			} 
		} 
	}
	
	public void pruebaTablero() {
		// initialize white pieces 
		boardGame[0][0] = null;
		boardGame[0][1] = null;
		boardGame[0][2] = null;
		boardGame[0][3] = null;
		boardGame[0][4] = null;
		boardGame[0][5] = null;
		boardGame[0][6] = null;
		boardGame[0][7] = null;
		//... 
		for(int i=0;i<ANCHO;i++) {
			boardGame[1][i] = new Peon(new Coordenada(i,1),Ficha.NEGRO); 
		}

		//... 

		// initialize black pieces 
	
		boardGame[7][1] = null; 
		boardGame[7][2] = null; 
		boardGame[7][3] = null; 
		boardGame[7][4] = null; 
		boardGame[7][5] = null; 
		boardGame[7][6] = null; 

		boardGame[7][0] = null; 
		boardGame[7][2] = null;
		boardGame[7][3] = null; 
		boardGame[7][4] = null; 
		boardGame[7][5] = null;
		boardGame[7][6] = null;
		boardGame[7][7] = null;
		
		//...
		for(int i=0;i<ANCHO;i++) {
			boardGame[6][i] = null; 
		} 
		//... 
		for(int i=0;i<ANCHO;i++) {
			boardGame[6][i] = null; 
		} 

		// initialize remaining boxes without any piece 
		for (int i = 2; i < 6; i++) { 
			for (int j = 0; j < 8; j++) { 
				boardGame[i][j] = null; 
			} 
		} 
		
		boardGame[4][3] = new Reina(new Coordenada(3,4),Ficha.BLANCO);
	}
	
	public void borrarFicha(Coordenada c) {
		if(boardGame[c.getY()][c.getX()]!=null) {
			boardGame[c.getY()][c.getX()]=null;
		}
		
	}
	
	public Ficha getFichaTablero(Coordenada c) {
		if(c.getX()<=7 && c.getX()>=0 && c.getY()<=7 && c.getY()>=0) {
			return boardGame[c.getY()][c.getX()];
		}else {
			return null;
		}
    }

    public void setFichaTablero(Ficha ficha, Coordenada c) {
        boardGame[c.getY()][c.getX()] = ficha;
        ficha.setPosicion(c);
    }

    public Ficha getFichaTablero(int x, int y){
    	if(x<=7 && x>=0 && y<=7 && y>=0) {
    		return boardGame[y][x];
    	}else {
    		return null;
    	}
    	
    }
    
    public boolean estaVacio(int x, int y) {
    	if(boardGame[y][x] == null) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public int getColorFicha(int x, int y) {
    	if(boardGame[y][x].getColor()==Ficha.BLANCO) {
    		return Ficha.BLANCO;
    	}else {
    		return Ficha.NEGRO;
    	}
    }
    
	public Ficha[][] getBoardGame() {
		return boardGame;
	} 
} 
